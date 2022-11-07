package br.com.bluesoft.alucar.entities;

import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Aluguel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "clienteId", referencedColumnName = "clienteId")
    @NotNull
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "carro_placa", referencedColumnName = "placa")
    @NotNull
    private Carro carro;

    @ManyToOne
    @JoinColumn(name = "vendedorId", referencedColumnName = "vendedorId")
    @NotNull
    private Vendedor vendedor;
    private Integer totalDias;

    private BigDecimal valorAluguelTotal;

    private LocalDate dataAluguel;


    public Aluguel(Cliente cliente, Carro carro, Vendedor vendedor, Integer totalDias, BigDecimal valorAluguelTotal, LocalDate dataAluguel) {
        this.cliente = cliente;
        this.carro = carro;
        this.vendedor = vendedor;
        this.totalDias = totalDias;
        this.valorAluguelTotal = valorAluguelTotal;
        this.dataAluguel = dataAluguel;
    }

    public Aluguel(Cliente cliente, Vendedor vendedor, Carro carro, Integer totalDias) {
        this.cliente = cliente;
        this.vendedor = vendedor;
        this.carro = carro;
        this.totalDias = totalDias;
    }

    private BigDecimal calculoPreco(Integer totalDias, BigDecimal diaria){
        return BigDecimal.valueOf(totalDias).multiply(diaria);
    }
}
