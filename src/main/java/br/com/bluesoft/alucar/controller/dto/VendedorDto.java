package br.com.bluesoft.alucar.controller.dto;


import br.com.bluesoft.alucar.entities.Vendedor;

public class VendedorDto {
    private Long id;
    private String nome;



    public VendedorDto(Long id, String nome) {
        super();
        this.id = id;
        this.nome = nome;
    }

    public VendedorDto(Vendedor vendedor) {
        super();
        id = vendedor.getVendedorId();
        nome = vendedor.getNome();
    }
}
