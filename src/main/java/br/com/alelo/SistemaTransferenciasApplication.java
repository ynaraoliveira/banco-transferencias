package br.com.alelo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;

import br.com.alelo.domain.Conta;
import br.com.alelo.domain.Transferencia;

@SpringBootApplication
@EntityScan(basePackageClasses = {Conta.class, Transferencia.class})
@ComponentScan("br.com.alelo.domain.*")
public class SistemaTransferenciasApplication {

	public static void main(String[] args) {
		SpringApplication.run(SistemaTransferenciasApplication.class, args);
	}

}
