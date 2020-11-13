package br.com.alelo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.alelo.domain.Conta;
import br.com.alelo.domain.Transferencia;
import br.com.alelo.repository.TransferenciaRepository;

@Service
public class TransferenciaService {

	@Autowired
	private TransferenciaRepository transferenciaRepository;

	@Autowired
	private br.com.alelo.repository.ContaRepository contaRepository;

	public ResponseEntity<Transferencia> criaNovaTransferencia(Integer origem, Integer destino, double valor) {
		// busca se conta de origem existe e traz o saldo
		Conta contaOrigem = this.contaRepository.findbyId(origem);

		if (contaOrigem != null) {
			Conta contadestino = this.contaRepository.findbyId(destino);
			if (contadestino != null) {
				if (contaOrigem.getSaldoDebito() >= valor) {
					transferenciaEntreContas(contaOrigem, contadestino, valor);
					return new ResponseEntity<Transferencia>(salvaTransferencia(contaOrigem, contadestino, valor), HttpStatus.OK);
				}
			}
		}
		return new ResponseEntity<Transferencia>(HttpStatus.BAD_REQUEST);
	}

	private void transferenciaEntreContas(Conta origem, Conta destino, double valor) {
		double saldoOrigem = origem.getSaldoDebito() - valor;
		origem.setSaldoDebito(saldoOrigem);
		double saldoDestino = destino.getSaldoDebito() + valor;
		destino.setSaldoDebito(saldoDestino);
		salvarConta(origem, destino);
	}
	


	private Transferencia salvaTransferencia(Conta origem, Conta destino, double valor) {
		Transferencia transferencia = new Transferencia(origem, destino, valor);
		transferenciaRepository.save(transferencia);
		return transferencia;
	}
	
	private void transferenciaRollback(Conta origem, Conta destino, double valor) {
		double saldoOrigem = origem.getSaldoDebito() + valor;
		origem.setSaldoDebito(saldoOrigem);
		double saldoDestino = destino.getSaldoDebito() - valor;
		destino.setSaldoDebito(saldoDestino);
		salvarConta(origem, destino);
	}
	
	private void salvarConta(Conta origem, Conta destino) {
		contaRepository.save(origem);
		contaRepository.save(destino);
	}
	
	public ResponseEntity<Transferencia> deletaTransferenciaEFazRollback(Integer idTransferencia) {
		Transferencia transferencia = transferenciaRepository.findbyId(idTransferencia);
		transferenciaRollback(transferencia.getOrigem(), transferencia.getDestino(), transferencia.getValorTransferencias());
		
		transferenciaRepository.delete(transferencia);
		return new ResponseEntity<Transferencia>(HttpStatus.OK);

		
	}

	public ResponseEntity<Transferencia> atualizaTransferenciaESaldos(Integer idTransferencia, double valorAtualizado) {
		
		//busca transferencia
		Transferencia transferencia = transferenciaRepository.findbyId(idTransferencia);
		
		//faz rollback
		transferenciaRollback(transferencia.getOrigem(), transferencia.getDestino(), transferencia.getValorTransferencias());

	
		Conta contaOrigem = this.contaRepository.findbyId(transferencia.getOrigem().getId());
		if (contaOrigem != null) {
			Conta contadestino = this.contaRepository.findbyId(transferencia.getDestino().getId());
			if (contadestino != null) {
				if (contaOrigem.getSaldoDebito() >= valorAtualizado) {
					transferenciaEntreContas(contaOrigem, contadestino, valorAtualizado);
					return new ResponseEntity<Transferencia>(salvaTransferencia(contaOrigem, contadestino, valorAtualizado), HttpStatus.OK);
				}
			}
		}
		return new ResponseEntity<Transferencia>(HttpStatus.BAD_REQUEST);
	}
	
	

	public Iterable<Transferencia> listaTransferencias() {
		return transferenciaRepository.findAll();
	}

}
