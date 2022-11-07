package br.com.bluesoft.alucar.entities;

import com.sun.istack.NotNull;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigInteger;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter

public class Vendedor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long vendedorId;
    private String nome;
    private BigInteger cpf;
    private LocalDate dataAdmissao;

    @OneToOne(mappedBy = "vendedor")
    private ContaCorrente contaCorrente;
}

