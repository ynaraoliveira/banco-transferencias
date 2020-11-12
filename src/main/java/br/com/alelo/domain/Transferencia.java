package br.com.alelo.domain;

import javax.persistence.Table;

import org.springframework.boot.autoconfigure.domain.EntityScan;

@EntityScan
@Table(name = "transferencia")
public class Transferencia {
	
	private Integer id;
	
	@OneToTOne
	private Conta origem;
	
	@OneToOne
	private Conta destino;
	
	private String tipo;
	
	private double valorTransferencias;
	
	public Transferencia(Conta origem, Conta destino, String tipo) {
		super();
		this.origem = origem;
		this.destino = destino;
		this.tipo = tipo;
	}
	
}
