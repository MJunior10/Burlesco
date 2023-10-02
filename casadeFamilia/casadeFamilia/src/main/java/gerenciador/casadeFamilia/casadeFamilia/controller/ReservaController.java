package gerenciador.casadeFamilia.casadeFamilia.controller;

import gerenciador.casadeFamilia.api.controller.CrudController;
import gerenciador.casadeFamilia.casadeFamilia.dto.*;
import gerenciador.casadeFamilia.casadeFamilia.mapper.FuncionariaMapper;
import gerenciador.casadeFamilia.casadeFamilia.mapper.ReservaMapper;
import gerenciador.casadeFamilia.casadeFamilia.model.Funcionaria;
import gerenciador.casadeFamilia.casadeFamilia.model.Reserva;
import gerenciador.casadeFamilia.casadeFamilia.repository.FuncionariaRepository;
import gerenciador.casadeFamilia.casadeFamilia.service.FuncionariaService;
import gerenciador.casadeFamilia.casadeFamilia.service.ReservaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/${app.api.version}/reserva")
public class ReservaController extends CrudController
        <Reserva, ReservaDTO, Long, ReservaMapper, ReservaService> {
    @PostMapping (path = "/pesquisar")
    @Operation(description = "Busca entidade pelos dados informados", responses = {
            @ApiResponse(responseCode = "200", description = "Listagem de reservas pela pesquisa",
                    content = @Content(mediaType = "application/json",
                            array = @ArraySchema(schema = @Schema(implementation = ReservaDTO.class))
                    ))})
    public List<ReservaDTO> pesquisar(
            @RequestBody ReservaDTO entidade
    ){
        Reserva reservaBusca = this.mapper.toModelo(entidade);
        List<Reserva> localizar = service.localizar(reservaBusca);
        return this.mapper.toDTO(localizar);
    }

    }
