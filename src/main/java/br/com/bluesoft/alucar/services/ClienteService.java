package br.com.bluesoft.alucar.services;

import br.com.bluesoft.alucar.entities.Cliente;
import br.com.bluesoft.alucar.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {
    @Autowired
    private ClienteRepository clienteRepository;

    //Ler dados
    public List<Cliente> buscarTodos() {
        return clienteRepository.findAll();
    }
}