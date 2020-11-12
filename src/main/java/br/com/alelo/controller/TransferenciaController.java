package br.com.alelo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.alelo.domain.*;

@RestController
public class TransferenciaController {
	
	@Autowired
	private TransferenciaService service;
	
	@PostMapping
	public Transferencia add() {
		//cria nova transferencia
	}
	
	@DeleteMapping
	public Transferencia delete() {
		//passa o id da transferencia retorna o saldo anterior
	}
	
	@PutMapping
	public Transferencia update() {
		//rollback
		//mudar o valor da conta origem 
		//mudar o valor da conta destino
		
	}
	
	@GetMapping 
	public List<Transferencia> list(){
		
	}

}
