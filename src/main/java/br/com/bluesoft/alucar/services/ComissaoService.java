package br.com.bluesoft.alucar.services;

import br.com.bluesoft.alucar.entities.Aluguel;
import br.com.bluesoft.alucar.repositories.AluguelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

@Service
public class ComissaoService {

    @Autowired
    private AluguelRepository aluguelRepository;

    // Funcionando
    public BigDecimal calculaComissao(Aluguel aluguel){
        return aluguel.getValorAluguelTotal().multiply(new BigDecimal(0.1));
    }

    public BigDecimal calculaComissaoEspecial(Aluguel aluguel){
        return aluguel.getValorAluguelTotal().multiply(new BigDecimal(0.13));
    }


}
