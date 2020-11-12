package br.com.alelo.domain;

import javax.annotation.Generated;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.annotation.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;

@EntityScan
@Table(name = "banco")
public class Banco {

	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	private String nome;
	private int numero;
	private int numeroAgencia;
	

	public Banco(String nome, int numero, int numeroAgencia) {
		super();
		this.nome = nome;
		this.numero = numero;
		this.numeroAgencia = numeroAgencia;
	}
	
}
