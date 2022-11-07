package br.com.bluesoft.alucar.controller;


import br.com.bluesoft.alucar.controller.dto.AluguelSimplesDto;
import br.com.bluesoft.alucar.controller.dto.DetalhesAluguelDto;
import br.com.bluesoft.alucar.controller.form.AluguelForm;
import br.com.bluesoft.alucar.entities.Aluguel;
import br.com.bluesoft.alucar.entities.Comissao;
import br.com.bluesoft.alucar.repositories.*;
import br.com.bluesoft.alucar.services.AluguelService;
import br.com.bluesoft.alucar.services.ComissaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/alugueis", produces = "application/json")
public class AluguelController {

    @Autowired
    private AluguelRepository aluguelRepository;
    @Autowired
    private CarroRepository carroRepository;
    @Autowired
    private ClienteRepository clienteRepository;
    @Autowired
    private VendedorRepository vendedorRepository;

    @Autowired
    private ComissaoRepository comissaoRepository;


    @PostMapping
    public void salvarAluguel(@RequestBody AluguelForm form) {
        Aluguel aluguel = form.converter(clienteRepository, carroRepository, vendedorRepository);
        aluguelRepository.save(aluguel);

        Boolean validadorIdade = ChronoUnit.YEARS.between(aluguel.getVendedor().getDataAdmissao(), LocalDate.now()) > 5;

        if (validadorIdade){
            BigDecimal valorComissao = new ComissaoService().calculaComissao(aluguel);
            Comissao comissao = new Comissao(valorComissao, aluguel.getVendedor(), aluguel.getVendedor().getContaCorrente());
            comissaoRepository.save(comissao);
        } else {
            BigDecimal valorComissao = new ComissaoService().calculaComissaoEspecial(aluguel);
            Comissao comissao = new Comissao(valorComissao, aluguel.getVendedor(), aluguel.getVendedor().getContaCorrente());
            comissaoRepository.save(comissao);
        }
    }

    @GetMapping
    public List<AluguelSimplesDto> lista(String nomeVendedor) {
        if (nomeVendedor == null) {
            List<Aluguel> contas = aluguelRepository.findAll();
            return AluguelSimplesDto.converter(contas);
        } else {
            List<Aluguel> contas = aluguelRepository.findByVendedorNome(nomeVendedor);
            return AluguelSimplesDto.converter(contas);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<DetalhesAluguelDto> detalhar(@PathVariable Long id) {
        Optional<Aluguel> aluguel = aluguelRepository.findById(id);
        if (aluguel.isPresent()) {
            return ResponseEntity.ok(new DetalhesAluguelDto(aluguel.get()));
        }
        return ResponseEntity.notFound().build();
    }
}

