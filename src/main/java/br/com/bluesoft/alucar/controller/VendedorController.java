package br.com.bluesoft.alucar.controller;


import br.com.bluesoft.alucar.controller.dto.VendedorDto;
import br.com.bluesoft.alucar.entities.Vendedor;
import br.com.bluesoft.alucar.services.VendedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/vendedores", produces = "application/json")
public class VendedorController {

    @Autowired
    private VendedorService vendedorService;

    @GetMapping
    public ResponseEntity<List<Vendedor>> buscarTodos() {
        List<Vendedor> vendedores = vendedorService.buscarTodos();
        return ResponseEntity.ok().body(vendedores);
    }


//    @GetMapping(path = "/{vendedor_id}")
//    public ResponseEntity<List<ContaCorrente>> buscarContasPorVendedor(@PathVariable Long vendedor_id) {
//        List<ContaCorrente> contasCorrentes = vendedorService.buscarContaCorrentePorVendedor(vendedor_id);
//        return ResponseEntity.ok().body(contasCorrentes);
//    }

    @GetMapping(value = "/{vendedor_id}")
    public VendedorDto findById(@PathVariable Long vendedor_id){
        return vendedorService.findById(vendedor_id);
    }

}
