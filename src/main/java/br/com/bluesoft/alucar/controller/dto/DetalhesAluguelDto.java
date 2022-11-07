package br.com.bluesoft.alucar.controller.dto;

import br.com.bluesoft.alucar.entities.*;
import lombok.Getter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
public class DetalhesAluguelDto {
    private Long id;
    private String nomeCliente;

    private String placaCarro;
    private String modeloCarro;
    private String nomeVendedor;
    private Integer totalDias;

    private BigDecimal valorAluguelTotal;

    private LocalDate dataAluguel;

    public DetalhesAluguelDto(Aluguel aluguel){
        this.id = aluguel.getId();
        this.nomeCliente = aluguel.getCliente().getNome();
        this.placaCarro = aluguel.getCarro().getPlaca();
        this.modeloCarro = aluguel.getCarro().getModelo();
        this.nomeVendedor = aluguel.getVendedor().getNome();
        this.totalDias = aluguel.getTotalDias();
        this.valorAluguelTotal = aluguel.getValorAluguelTotal();
        this.dataAluguel = aluguel.getDataAluguel();
    }
}
