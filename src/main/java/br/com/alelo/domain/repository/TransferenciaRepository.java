package br.com.alelo.domain.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.alelo.domain.Transferencia;

@Repository
public interface TransferenciaRepository extends CrudRepository<Transferencia, Integer> {

}
