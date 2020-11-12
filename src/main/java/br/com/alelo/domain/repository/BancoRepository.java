package br.com.alelo.domain.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.alelo.domain.Banco;


@Repository
public interface BancoRepository extends CrudRepository<Banco, Integer>{

}
