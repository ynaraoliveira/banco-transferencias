package br.com.alelo.domain;

import java.util.List;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.annotation.Id;

@EntityScan
@Table(name = "conta")
public class Conta {

	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	
	private String nome;
	
	private String documento;
	
	private String conta;
	
	@OneToOne
	private Banco banco;
	
	private double saldoDebito;
	
	@OneToMany
	private List<Transferencia> transferencias;
	
	public Conta(String nome, String documento, String conta, Banco banco, double saldoDebito, double saldoCredito) {
		super();
		this.nome = nome;
		this.documento = documento;
		this.conta = conta;
		this.banco = banco;
		this.saldoDebito = saldoDebito;

	}
	
}
