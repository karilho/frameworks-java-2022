package br.com.bluesoft.alucar.repositories;

import br.com.bluesoft.alucar.entities.Carro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarroRepository extends JpaRepository<Carro, Long> {
    Carro findByPlaca(String placa);
}
