package br.com.bluesoft.alucar.repositories;

import br.com.bluesoft.alucar.entities.ContaCorrente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ContaCorrenteRepository extends JpaRepository<ContaCorrente, Long> {

    List<ContaCorrente> findContaCorrentesByVendedor(Long vendedor_id);

    List<ContaCorrente> findByVendedorNome(String nomeVendedor);

}
