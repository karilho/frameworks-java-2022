package br.com.bluesoft.alucar.controller.dto;

import br.com.bluesoft.alucar.entities.Aluguel;
import br.com.bluesoft.alucar.entities.Comissao;
import lombok.Getter;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;
import java.util.stream.Collectors;


@Getter
public class ComissaoDto {

    private String nomeVendedor;
    private BigInteger cpfVendedor;
    private BigDecimal valorComissao;
    private String nomeBanco;
    private Integer contaAgencia;
    private Integer contaCorrenteNumero;

    public ComissaoDto(Comissao comissao) {
        this.nomeVendedor = comissao.getVendedor().getNome();
        this.cpfVendedor = comissao.getVendedor().getCpf();
        this.valorComissao = comissao.getValorComissao();
        this.nomeBanco = comissao.getContaCorrente().getBanco();
        this.contaAgencia = comissao.getContaCorrente().getAgencia();
        this.contaCorrenteNumero = comissao.getContaCorrente().getConta_corrente();
    }
    public static List<ComissaoDto> converter(List<Comissao> alugueis) {
        return alugueis.stream().map(ComissaoDto::new).collect(Collectors.toList());
    }
}
