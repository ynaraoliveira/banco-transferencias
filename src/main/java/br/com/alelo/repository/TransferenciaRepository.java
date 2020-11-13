package br.com.alelo.repository;
import br.com.alelo.domain.Transferencia;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.stereotype.Repository;

@NoRepositoryBean
@Repository
public interface TransferenciaRepository extends CrudRepository<Transferencia, Integer> {
	
	public Transferencia findbyId(Integer id);

}
