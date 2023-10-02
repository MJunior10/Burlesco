package gerenciador.casadeFamilia.casadeFamilia.repository;

import gerenciador.casadeFamilia.casadeFamilia.model.Funcionaria;
import gerenciador.casadeFamilia.casadeFamilia.model.Reserva;

import java.util.List;

public interface ReservaRepositoryCustom {
    List<Reserva> localizarPorReserva(Reserva reserva);
}
