package gerenciador.casadeFamilia.casadeFamilia.mapper;

import gerenciador.casadeFamilia.api.mapper.BaseMapper;
import gerenciador.casadeFamilia.casadeFamilia.dto.FuncionariaDTO;
import gerenciador.casadeFamilia.casadeFamilia.dto.FuncionariaDadosAlteravelDTO;
import gerenciador.casadeFamilia.casadeFamilia.dto.FuncionariaListaDTO;
import gerenciador.casadeFamilia.casadeFamilia.dto.ReservaDTO;
import gerenciador.casadeFamilia.casadeFamilia.model.Funcionaria;
import gerenciador.casadeFamilia.casadeFamilia.model.Reserva;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface FuncionariaMapper extends BaseMapper<Funcionaria, FuncionariaDTO> {

}
