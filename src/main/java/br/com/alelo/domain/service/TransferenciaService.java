package br.com.alelo.domain.service;

import org.springframework.stereotype.Service;

@Service
public class TransferenciaService {
	
	@Autowired
	private TransferenciaRepository transferenciaRepository;
	
	@Autowired
	private BancoRepository bancoRepository;
	
	@Autowired
	private ContaRepository ContaRepository;
	
	
	private Transferencia criaNovaTransferencia(Conta origem, Conta destino, double valor) {
		//busca se conta de origem existe e traz o saldo
		
		//busca conta de destino 
		
		//debita saldo na conta origem
		//credita saldo na conta destino
		
		//salva transferencia
		
		}
	
	private void deletaTransferenciaEFazRollback(Integer idTransferencia) {
		//busca transferencia e retorna valor
	}
	
	private Transferencia atualizaTransferenciaESaldos(Integer idTransferencia) {
		//buscar transferencia pelo id
		//pegar as contas e atualizar saldos
		//atualizar a transferencia
		
	}
	
	private List<Transferencia> listaTransferencias(){
		//so trazer tudo
		return transferenciaRepository.findAll();
	}
	
}
