package gerenciador.casadeFamilia.casadeFamilia.service.impl;

import gerenciador.casadeFamilia.api.service.BaseCrudService;
import gerenciador.casadeFamilia.casadeFamilia.model.Funcionaria;
import gerenciador.casadeFamilia.casadeFamilia.model.Reserva;
import gerenciador.casadeFamilia.casadeFamilia.service.FuncionariaService;
import gerenciador.casadeFamilia.casadeFamilia.repository.FuncionariaRepository;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.sql.Date;
import java.time.LocalDate;
import java.time.Period;
import java.util.*;

@Service
public class FuncionariaServiceImpl
        extends BaseCrudService<Funcionaria, Long, FuncionariaRepository>
        implements FuncionariaService {

    @Override
    protected void prepararParaIncluir(Funcionaria entidade) {

        this.validarIdade(entidade);

    }
    @Override
    protected void validarDados(Funcionaria entidade) {

    }
    @Override
    protected void validarCamposObrigatorios(Funcionaria entidade) {

    }
    public  static int idade(LocalDate dataNascimento)
    {
        LocalDate dataAtual = LocalDate.now();
        Period periodo = Period.between(dataNascimento, dataAtual);
        return periodo.getYears();
    }
    private void validarIdade(Funcionaria funcionaria)
   {

        if(idade(funcionaria.getDataNascimento()) < 18)
        {
            throw new IllegalArgumentException("Idade não pode ser menor que 18 anos");
        } else if (idade(funcionaria.getDataNascimento()) > 50) {
            throw new IllegalArgumentException("Idade não pode ser maior que 50 anos");
        }
   }
}

