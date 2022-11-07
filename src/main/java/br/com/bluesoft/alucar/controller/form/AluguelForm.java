package br.com.bluesoft.alucar.controller.form;

import br.com.bluesoft.alucar.entities.*;
import br.com.bluesoft.alucar.repositories.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDate;

@Getter
@Setter
public class AluguelForm {
    private BigInteger cpfCliente;
    private BigInteger cpfVendedor;
    private String placaCarro;
    private Integer totalDias;

    public Aluguel converter(ClienteRepository clienteRepository, CarroRepository carroRepository, VendedorRepository vendedorRepository) {
        Cliente cliente = clienteRepository.findByCpf(cpfCliente);
        Carro carro = carroRepository.findByPlaca(placaCarro);
        Vendedor vendedor = vendedorRepository.findByCpf(cpfVendedor);
        BigDecimal valorAluguelTotal = carro.getDiaria().multiply(new BigDecimal(this.totalDias));
        return new Aluguel(cliente, carro, vendedor,  totalDias, valorAluguelTotal, LocalDate.now());
    }
}
