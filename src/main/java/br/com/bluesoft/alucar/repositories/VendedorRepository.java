package br.com.bluesoft.alucar.repositories;

import br.com.bluesoft.alucar.entities.Cliente;
import br.com.bluesoft.alucar.entities.ContaCorrente;
import br.com.bluesoft.alucar.entities.Vendedor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigInteger;
import java.util.List;

public interface VendedorRepository extends JpaRepository<Vendedor, Long> {
    Vendedor findByCpf(BigInteger cpf);
}
