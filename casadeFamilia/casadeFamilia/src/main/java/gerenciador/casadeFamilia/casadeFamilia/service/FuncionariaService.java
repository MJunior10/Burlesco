package gerenciador.casadeFamilia.casadeFamilia.service;

import gerenciador.casadeFamilia.api.service.CrudService;
import gerenciador.casadeFamilia.casadeFamilia.model.Funcionaria;
import gerenciador.casadeFamilia.casadeFamilia.model.Reserva;

import java.util.List;

public interface FuncionariaService extends CrudService<Funcionaria, Long> {
    public List<Funcionaria> localizar(Funcionaria funcionaria);
}
