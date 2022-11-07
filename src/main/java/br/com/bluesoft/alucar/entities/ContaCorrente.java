package br.com.bluesoft.alucar.entities;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class ContaCorrente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long contaId;
    private String banco;
    private Integer agencia;
    private Integer conta_corrente;
    @OneToOne
    private Vendedor vendedor;

    public ContaCorrente(String banco, Integer agencia, Integer conta_corrente, Vendedor vendedor) {
        this.banco = banco;
        this.agencia = agencia;
        this.conta_corrente = conta_corrente;
        this.vendedor = vendedor;
    }

}
