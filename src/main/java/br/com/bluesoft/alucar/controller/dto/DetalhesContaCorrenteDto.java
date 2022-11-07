package br.com.bluesoft.alucar.controller.dto;

import br.com.bluesoft.alucar.entities.ContaCorrente;
import br.com.bluesoft.alucar.entities.Vendedor;
import lombok.Getter;

@Getter
public class DetalhesContaCorrenteDto {

    private Long conta_corrente_key;
    private String banco;
    private Integer agencia;
    private Integer conta_corrente;
    private String nomeVendedor;

    public DetalhesContaCorrenteDto(ContaCorrente contaCorrente) {
        this.conta_corrente_key = contaCorrente.getContaId();
        this.banco = contaCorrente.getBanco();
        this.agencia = contaCorrente.getAgencia();
        this.conta_corrente = contaCorrente.getConta_corrente();
        this.nomeVendedor = contaCorrente.getVendedor().getNome();
    }
}

