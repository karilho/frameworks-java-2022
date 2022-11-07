package br.com.bluesoft.alucar.controller;


import br.com.bluesoft.alucar.entities.Carro;
import br.com.bluesoft.alucar.services.CarroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/carros", produces = "application/json")
public class CarroController {
    @Autowired
    private CarroService carroService;

    @GetMapping
    public ResponseEntity<List<Carro>> buscarTodos() {
        List<Carro> carros = carroService.buscarTodos();
        return ResponseEntity.ok().body(carros);
    }
}
