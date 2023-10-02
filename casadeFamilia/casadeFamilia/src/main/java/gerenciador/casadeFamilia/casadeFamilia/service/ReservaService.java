package gerenciador.casadeFamilia.casadeFamilia.service;

import gerenciador.casadeFamilia.api.service.CrudService;
import gerenciador.casadeFamilia.casadeFamilia.model.Funcionaria;
import gerenciador.casadeFamilia.casadeFamilia.model.Reserva;

import java.util.List;

public interface ReservaService extends CrudService<Reserva, Long> {
      public List<Reserva> localizar(Reserva reserva);

}
