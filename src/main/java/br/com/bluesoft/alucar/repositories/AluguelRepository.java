package br.com.bluesoft.alucar.repositories;

import br.com.bluesoft.alucar.entities.Aluguel;
import br.com.bluesoft.alucar.entities.ContaCorrente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigInteger;
import java.util.List;

public interface AluguelRepository extends JpaRepository<Aluguel, Long> {

    List<Aluguel> findByVendedorNome(String nomeVendedor);
    Aluguel findByValorAluguelTotal(BigInteger valorAluguelTotal);
}