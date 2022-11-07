package br.com.bluesoft.alucar.controller.dto;

import br.com.bluesoft.alucar.entities.ContaCorrente;
import br.com.bluesoft.alucar.entities.Vendedor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.util.List;
import java.util.stream.Collectors;

@Getter
public class ContaCorrenteDto {

    private Long conta_corrente_key;
    private String banco;
    private Integer agencia;
    private Integer conta_corrente;
    private Vendedor vendedor;

    public ContaCorrenteDto(ContaCorrente contaCorrente) {
        this.banco = contaCorrente.getBanco();
        this.agencia = contaCorrente.getAgencia();
        this.conta_corrente = contaCorrente.getConta_corrente();
        this.vendedor = contaCorrente.getVendedor();
    }

    public static List<ContaCorrenteDto> converter(List<ContaCorrente> contaCorrentes) {
        return contaCorrentes.stream().map(ContaCorrenteDto::new).collect(Collectors.toList());
    }

}
