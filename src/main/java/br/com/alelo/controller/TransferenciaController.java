package br.com.alelo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import br.com.alelo.domain.*;

@Controller
public class TransferenciaController {
	
	@PostMapping
	public Transferencia add() {
		
	}
	
	@DeleteMapping
	public Transferencia delete() {
		
	}
	
	@PutMapping
	public Transferencia update() {
		
	}
	
	@GetMapping 
	public List<Transferencia> list(){
		
	}

}
