package br.com.alelo.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.alelo.domain.*;
import br.com.alelo.service.TransferenciaService;

@RestController(value = "transferencia")
public class TransferenciaController {
	
	@Autowired
	private TransferenciaService service;
	
	@PostMapping
	public ResponseEntity<Transferencia> add(@RequestBody Integer origem, Integer destino, double valor) {
		return service.criaNovaTransferencia(origem, destino, valor);
	}
	
	@DeleteMapping
	public ResponseEntity<Transferencia> delete(@RequestBody Integer idTransferencia) {
		return service.deletaTransferenciaEFazRollback(idTransferencia);
	}
	
	@PutMapping
	public ResponseEntity<Transferencia> update(@RequestBody Integer idTransferencia, double valorAtualizado) {
		return service.atualizaTransferenciaESaldos(idTransferencia, valorAtualizado);
	}
	
	@GetMapping 
	public Iterable<Transferencia> list(){
		return service.listaTransferencias();
		
	}

}
