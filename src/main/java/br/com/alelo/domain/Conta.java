package br.com.alelo.domain;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.boot.autoconfigure.domain.EntityScan;

@EntityScan
@Table(name = "conta")
public class Conta {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "nome")
	private String nome;
	
	@Column(name = "documento")
	private String documento;
	
	@Column(name = "conta")
	private String conta;
	
    @OneToOne(mappedBy = "conta")
    private Transferencia transferencia;
	
    @Column(name = "saldoDebito")
	private double saldoDebito;
	
	public Conta(String nome, String documento, String conta, double saldoDebito, double saldoCredito) {
		super();
		this.nome = nome;
		this.documento = documento;
		this.conta = conta;
		this.saldoDebito = saldoDebito;

	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDocumento() {
		return documento;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
	}

	public String getConta() {
		return conta;
	}

	public void setConta(String conta) {
		this.conta = conta;
	}

	public double getSaldoDebito() {
		return saldoDebito;
	}

	public void setSaldoDebito(double saldoDebito) {
		this.saldoDebito = saldoDebito;
	}
	
}
