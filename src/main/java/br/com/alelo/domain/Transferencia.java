package br.com.alelo.domain;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import br.com.alelo.domain.Conta;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@EntityScan
@Table(name = "transferencia")
public class Transferencia {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Integer id;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "conta_id", referencedColumnName = "id")
	private Conta origem;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "conta_id", referencedColumnName = "id")
	private Conta destino;

	@Column(name = "valorTransferencia")
	private double valorTransferencia;

	public Transferencia(Conta origem, Conta destino, double valorTransferencias) {
		super();
		this.origem = origem;
		this.destino = destino;
		this.valorTransferencia = valorTransferencia;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Conta getOrigem() {
		return origem;
	}

	public void setOrigem(Conta origem) {
		this.origem = origem;
	}

	public Conta getDestino() {
		return destino;
	}

	public void setDestino(Conta destino) {
		this.destino = destino;
	}

	public double getValorTransferencias() {
		return valorTransferencia;
	}

	public void setValorTransferencias(double valorTransferencias) {
		this.valorTransferencia = valorTransferencias;
	}

}
