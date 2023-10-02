package gerenciador.casadeFamilia.api.controller;

import gerenciador.casadeFamilia.api.exception.MessageResponse;
import gerenciador.casadeFamilia.api.mapper.BaseMapper;
import gerenciador.casadeFamilia.api.model.IEntidade;
import gerenciador.casadeFamilia.api.service.CrudService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public abstract class CrudController<
        ENTIDADE extends IEntidade<PK_TYPE>,
        DTO,
        PK_TYPE,
        MAPPER extends BaseMapper<ENTIDADE, DTO>,
        SERVICE extends CrudService<ENTIDADE, PK_TYPE>
        > {

    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    protected MAPPER mapper;

    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    protected SERVICE service;

    @GetMapping()
    @Operation(description = "Listagem Geral", responses = {
            @ApiResponse(responseCode = "200", description = "Listagem geral",
                    content = @Content(
                            mediaType = "application/json",
                            array = @ArraySchema())),
            @ApiResponse(responseCode = "404", description = "Registro náo encontrado",
                    content = @Content(mediaType = "application/json"))
    })
    public ResponseEntity<List<DTO>> listAll(){
        List<ENTIDADE> modelo = service.listarTodos();
        return ResponseEntity.ok(mapper.toDTO(modelo));
    }

    @PostMapping
    @Operation(description = "Método utilizado para realizar a inclusão de um entidade", responses = {
            @ApiResponse(responseCode = "200", description = "Entidade Incluida", content = @Content(mediaType = "application/json")),
            @ApiResponse(responseCode = "400", description = "Campos Obrigatórios não informados",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = MessageResponse.class)
                    )
            )
    })
    public ResponseEntity<DTO> incluir(@RequestBody DTO modeloDTO){
        //prepração para entrada.
        ENTIDADE modeloIncluir = this.mapper.toModelo(modeloDTO);
        modeloIncluir.setId(null);
        //chamada do serviço
        System.out.println(modeloIncluir);
        modeloIncluir = this.service.incluir(modeloIncluir);

        //preparação para o retorno
        return ResponseEntity.ok(this.mapper.toDTO(modeloIncluir));
    }

    @PutMapping(path = "/{id}")
    @Operation(description = "Método utilizado para altlerar os dados de uma entidiade", responses = {
            @ApiResponse(responseCode = "200", description = "Listagem geral",
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = Object.class))),
            @ApiResponse(responseCode = "404", description = "Registro náo encontrado",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = MessageResponse.class)))
    }
    )
    public ResponseEntity<DTO> alterar(@RequestBody() DTO modeloDTO, @PathVariable(name = "id") PK_TYPE id
    ){
        ENTIDADE pModelo = mapper.toModelo(modeloDTO);
        ENTIDADE alterar = service.alterar(pModelo, id);
        return ResponseEntity.ok(mapper.toDTO(alterar));
    }
    @DeleteMapping(path ="/{id}")
    @Operation(description = "Método utilizado para remover uma entidiade pela id informado", responses = {
            @ApiResponse(responseCode = "200", description = "Entidade Removida", content = @Content(mediaType = "application/json"))})
    public ResponseEntity<DTO> remover(@PathVariable(name = "id") PK_TYPE id){
        ENTIDADE modeloExcluido = this.service.excluir(id);
        return ResponseEntity.ok(mapper.toDTO(modeloExcluido));
    }

    @GetMapping(path = "/{id}")
    @Operation(description = "Obter os dados completos de uma entidiade pelo id informado!", responses = {
            @ApiResponse(responseCode = "200", description = "Entidade encontrada", content = @Content(mediaType = "application/json"))})
    public ResponseEntity<DTO> ObterPorId(@PathVariable(name = "id") PK_TYPE id){
        ENTIDADE aluno = this.service.obterPeloId(id);
        return ResponseEntity.ok(this.mapper.toDTO(aluno));
    }
//    @GetMapping(path = "/pesquisar")
//    @Operation(description = "Busca entidade pelos dados informados", responses = {
//            @ApiResponse(responseCode = "200", description = "Listagem de reservas pela pesquisa",
//                    content = @Content(mediaType = "application/json",
//                            array = @ArraySchema(schema = @Schema(implementation = FuncionariaDTO.class))
//                    ))})
//    public List<ReservaListaDTO> pesquisar(
//            @RequestBody DTO entidade
//    ){
//        ENTIDADE entidadeBusca = this.mapper.toModelo(entidade);
//        List<ENTIDADE> localizar = service.localizar(entidadeBusca);
//        return this.mapper.toDTO(localizar);
//    }

}
