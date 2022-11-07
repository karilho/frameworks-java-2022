package br.com.bluesoft.alucar.controller;


import br.com.bluesoft.alucar.controller.dto.ContaCorrenteDto;
import br.com.bluesoft.alucar.controller.dto.DetalhesContaCorrenteDto;
import br.com.bluesoft.alucar.entities.Carro;
import br.com.bluesoft.alucar.entities.ContaCorrente;
import br.com.bluesoft.alucar.repositories.ContaCorrenteRepository;
import br.com.bluesoft.alucar.repositories.VendedorRepository;
import br.com.bluesoft.alucar.services.CarroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/contacorrentes", produces = "application/json")
public class ContaCorrenteController {

    @Autowired
    private ContaCorrenteRepository contaCorrenteRepository;

    @Autowired
    private VendedorRepository vendedorRepository;



    @GetMapping
    public List<ContaCorrenteDto> lista(String nomeVendedor) {
        if (nomeVendedor == null) {
            List<ContaCorrente> contas = contaCorrenteRepository.findAll();
            return ContaCorrenteDto.converter(contas);
        } else {
            List<ContaCorrente> contas = contaCorrenteRepository.findByVendedorNome(nomeVendedor);
            return ContaCorrenteDto.converter(contas);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<DetalhesContaCorrenteDto> detalhar(@PathVariable Long id) {
        Optional<ContaCorrente> conta = contaCorrenteRepository.findById(id);
        if (conta.isPresent()) {
            return ResponseEntity.ok(new DetalhesContaCorrenteDto(conta.get()));
        }
        return ResponseEntity.notFound().build();
    }

}
