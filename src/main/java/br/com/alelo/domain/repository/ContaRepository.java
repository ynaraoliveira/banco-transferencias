package br.com.alelo.domain.repository;

import org.springframework.data.repository.CrudRepository;

import br.com.alelo.domain.Conta;

public interface ContaRepository extends CrudRepository<Conta, Integer> {

}
