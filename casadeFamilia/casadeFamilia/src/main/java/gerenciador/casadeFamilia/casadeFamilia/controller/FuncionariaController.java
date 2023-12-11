package gerenciador.casadeFamilia.casadeFamilia.controller;

import gerenciador.casadeFamilia.api.controller.CrudController;
import gerenciador.casadeFamilia.casadeFamilia.dto.FuncionariaDTO;
import gerenciador.casadeFamilia.casadeFamilia.dto.FuncionariaDadosAlteravelDTO;
import gerenciador.casadeFamilia.casadeFamilia.dto.FuncionariaListaDTO;
import gerenciador.casadeFamilia.casadeFamilia.dto.ReservaDTO;
import gerenciador.casadeFamilia.casadeFamilia.mapper.FuncionariaMapper;
import gerenciador.casadeFamilia.casadeFamilia.mapper.ReservaMapper;
import gerenciador.casadeFamilia.casadeFamilia.model.Funcionaria;
//import io.swagger.annotations.Api;
import gerenciador.casadeFamilia.casadeFamilia.model.Reserva;
import gerenciador.casadeFamilia.casadeFamilia.service.FuncionariaService;
import gerenciador.casadeFamilia.casadeFamilia.service.ReservaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.persistence.Id;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping(path = "${app.api.base}/funcionaria")
public class FuncionariaController extends CrudController
        <Funcionaria, FuncionariaDTO, Long, FuncionariaMapper, FuncionariaService> {

    @PostMapping (path = "/pesquisar")
    @Operation(description = "Busca entidade pelos dados informados", responses = {
            @ApiResponse(responseCode = "200", description = "Listagem de funcionaria pela pesquisa",
                    content = @Content(mediaType = "application/json",
                            array = @ArraySchema(schema = @Schema(implementation = FuncionariaDTO.class))
                    ))})
    public List<FuncionariaDTO> pesquisar(
            @RequestBody FuncionariaDTO entidade
    ){
        Funcionaria funcionariaBusca = this.mapper.toModelo(entidade);
        List<Funcionaria> localizar = service.localizar(funcionariaBusca);
        return this.mapper.toDTO(localizar);
    }

    }
