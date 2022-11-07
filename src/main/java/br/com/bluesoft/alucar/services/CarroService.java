package br.com.bluesoft.alucar.services;

import br.com.bluesoft.alucar.entities.Carro;
import br.com.bluesoft.alucar.repositories.CarroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarroService {
    @Autowired
    private CarroRepository carroRepository;

    //Ler dados
    public List<Carro> buscarTodos() {
        return carroRepository.findAll();
    }
}