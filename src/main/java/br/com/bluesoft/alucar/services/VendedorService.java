package br.com.bluesoft.alucar.services;

import br.com.bluesoft.alucar.controller.dto.VendedorDto;
import br.com.bluesoft.alucar.entities.ContaCorrente;
import br.com.bluesoft.alucar.entities.Vendedor;
import br.com.bluesoft.alucar.repositories.ContaCorrenteRepository;
import br.com.bluesoft.alucar.repositories.VendedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VendedorService {
    @Autowired
    private VendedorRepository vendedorRepository;

    @Autowired
    private ContaCorrenteRepository contaCorrenteRepository;

    //Ler dados
    public List<Vendedor> buscarTodos() {
        return vendedorRepository.findAll();
    }

    public List<ContaCorrente> buscarContaCorrentePorVendedor(Long vendedor_id){
        return contaCorrenteRepository.findContaCorrentesByVendedor(vendedor_id);
    }

    public VendedorDto findById(Long vendedor_id){
        Vendedor entity = vendedorRepository.findById(vendedor_id).get();
        VendedorDto dto = new VendedorDto(entity);
        return dto;
    }
}