package br.com.bluesoft.alucar.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Getter
@Setter
public class Carro {
    @Id
    private String placa;
    private String marca;
    private String modelo;
    private String cor;
    private Integer ano;
    private Integer quilometragem;
    private BigDecimal diaria;
}
