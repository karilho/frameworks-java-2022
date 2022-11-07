package br.com.bluesoft.alucar.controller.dto;

import br.com.bluesoft.alucar.entities.*;
import lombok.Getter;

import java.math.BigInteger;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Getter
public class AluguelSimplesDto {
    private Long id;
    private BigInteger cpfCliente;

    private String placaCarro;

    private BigInteger cpfVendedor;
    private Integer totalDias;

//    private LocalDate dataAluguel;


    public AluguelSimplesDto(Aluguel aluguel){
        this.id = aluguel.getId();
        this.cpfVendedor = aluguel.getVendedor().getCpf();
        this.cpfCliente = aluguel.getCliente().getCpf();
        this.placaCarro = aluguel.getCarro().getPlaca();
        this.totalDias = aluguel.getTotalDias();
//        this.dataAluguel = aluguel.getDataAluguel();
    }

    public static List<AluguelSimplesDto> converter(List<Aluguel> alugueis) {
        return alugueis.stream().map(AluguelSimplesDto::new).collect(Collectors.toList());
    }

}
