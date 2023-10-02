package gerenciador.casadeFamilia.casadeFamilia.service.impl;

import gerenciador.casadeFamilia.api.service.BaseCrudService;
import gerenciador.casadeFamilia.casadeFamilia.model.Funcionaria;
import gerenciador.casadeFamilia.casadeFamilia.model.Reserva;
import gerenciador.casadeFamilia.casadeFamilia.repository.FuncionariaRepository;
import gerenciador.casadeFamilia.casadeFamilia.repository.ReservaRepository;
import gerenciador.casadeFamilia.casadeFamilia.service.FuncionariaService;
import gerenciador.casadeFamilia.casadeFamilia.service.ReservaService;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;
import java.util.*;

@Service
public class ReservaServiceImpl
        extends BaseCrudService<Reserva, Long, ReservaRepository>
        implements ReservaService {

    @Autowired
    private FuncionariaRepository funcionariaRepository;

    @Autowired
    public ReservaRepository reservaRepository;
    @Override
    protected void prepararParaIncluir(Reserva entidade) {
        tratarReserva(entidade);
        this.validarReserva(entidade);
    }
    private void tratarReserva(Reserva reserva) {
        if(Objects.isNull(reserva) ||
                Objects.isNull(reserva.getFuncionaria()) ||
                Objects.isNull(reserva.getFuncionaria().getId())
        ) return;
        Optional<Funcionaria> funcionariaOptional = funcionariaRepository.findById(reserva.getFuncionaria().getId());
        funcionariaOptional.ifPresent(funcionaria -> reserva.setFuncionaria(funcionaria));
    }
    @Override
    public Reserva alterar(Reserva entidade, Long id) {
        this.tratarReserva(entidade);
        return super.alterar(entidade, id);
    }

    @Override
    protected void validarDados(Reserva entidade) {


    }
    private void validarReserva(Reserva reserva)
    {

        if (reserva.getDataReserva().isBefore(LocalDate.now())) {
            throw new IllegalArgumentException("Data da reserva não pode ser inferior a data Atual");
       }
    }
    @Override
    protected void validarCamposObrigatorios(Reserva entidade) {

    }

    @Override
    public List<Reserva> localizar(Reserva reserva) {
        return this.reservaRepository.localizarPorReserva(reserva);
    }
}

