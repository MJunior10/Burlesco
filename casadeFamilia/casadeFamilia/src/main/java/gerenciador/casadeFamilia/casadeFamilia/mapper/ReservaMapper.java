package gerenciador.casadeFamilia.casadeFamilia.mapper;

import gerenciador.casadeFamilia.api.mapper.BaseMapper;
import gerenciador.casadeFamilia.casadeFamilia.dto.*;
import gerenciador.casadeFamilia.casadeFamilia.model.Funcionaria;
import gerenciador.casadeFamilia.casadeFamilia.model.Reserva;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ReservaMapper  extends BaseMapper<Reserva, ReservaDTO> {

    @Override
    @Mapping(source = "funcionaria.id" , target = "funcionaria_id")
    ReservaDTO toDTO(Reserva modelo);

    @Override
    @Mapping(source = "funcionaria_id", target = "funcionaria.id")
   Reserva toModelo(ReservaDTO rerservaDTO);

    @Override
    List<ReservaDTO> toDTO(List<Reserva> lista);
}
