package br.com.alelo.domain.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.alelo.domain.Conta;

@Repository
public interface ContaRepository extends CrudRepository<Conta, Integer> {

}
