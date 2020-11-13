package br.com.alelo.repository;


import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.stereotype.Repository;

import br.com.alelo.domain.Conta;


@Repository
@NoRepositoryBean
public interface ContaRepository extends CrudRepository<Conta, Integer> {

	public Conta findbyId(Integer id);
}
