package br.com.bluesoft.alucar.services;

import br.com.bluesoft.alucar.controller.dto.AluguelSimplesDto;
import br.com.bluesoft.alucar.entities.Aluguel;
import br.com.bluesoft.alucar.repositories.AluguelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AluguelService {
    @Autowired
    private AluguelRepository aluguelRepository;


    //Ler todos aluguéis
    public List<Aluguel> buscarTodos() {
        return aluguelRepository.findAll();
    }

    //Buscar um aluguel
    public Optional<Aluguel> buscarUm(Long id) {
        Optional<Aluguel> aluguelEncontrado = aluguelRepository.findById(id);
        return aluguelEncontrado;
    }
}
