package br.com.bluesoft.alucar.repositories;

import br.com.bluesoft.alucar.entities.Carro;
import br.com.bluesoft.alucar.entities.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigInteger;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    Cliente findByCpf(BigInteger cpfCliente);

}
