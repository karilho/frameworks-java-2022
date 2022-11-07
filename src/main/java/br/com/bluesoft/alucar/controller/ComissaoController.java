package br.com.bluesoft.alucar.controller;

import br.com.bluesoft.alucar.controller.dto.AluguelSimplesDto;
import br.com.bluesoft.alucar.controller.dto.ComissaoDto;
import br.com.bluesoft.alucar.controller.dto.DetalhesAluguelDto;
import br.com.bluesoft.alucar.entities.Aluguel;
import br.com.bluesoft.alucar.entities.Cliente;
import br.com.bluesoft.alucar.entities.Comissao;
import br.com.bluesoft.alucar.repositories.ComissaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/comissoes", produces = "application/json")
public class ComissaoController {
    @Autowired
    private ComissaoRepository comissaoRepository;

    @GetMapping
    public List<ComissaoDto> lista(String nomeVendedor) {
        List<Comissao> comissoes = comissaoRepository.findAll();
        return ComissaoDto.converter(comissoes);
        }


    @GetMapping("/{id}")
    public ResponseEntity<ComissaoDto> detalhar(@PathVariable Long id) {
        Optional<Comissao> comissao = comissaoRepository.findById(id);
        if (comissao.isPresent()) {
            return ResponseEntity.ok(new ComissaoDto(comissao.get()));
        }
        return ResponseEntity.notFound().build();
    }
}
