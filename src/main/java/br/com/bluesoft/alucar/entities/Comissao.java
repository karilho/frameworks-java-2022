package br.com.bluesoft.alucar.entities;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Comissao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long comissaoId;

    private BigDecimal valorComissao;

    @ManyToOne
    @JoinColumn(name = "vendedorId", referencedColumnName = "vendedorId")
    @NotNull
    private Vendedor vendedor;

    @OneToOne
    @JoinColumn(name = "contaId", referencedColumnName = "contaId")
    private ContaCorrente contaCorrente;


    public Comissao(BigDecimal valorComissao, Vendedor vendedor, ContaCorrente contaCorrente) {
        this.valorComissao = valorComissao;
        this.vendedor = vendedor;
        this.contaCorrente = contaCorrente;

    }
}
