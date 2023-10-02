package gerenciador.casadeFamilia.api.service;

import gerenciador.casadeFamilia.casadeFamilia.exception.SistemaMessageCode;
import gerenciador.casadeFamilia.api.exception.BusinessException;
import gerenciador.casadeFamilia.api.model.IEntidade;
import gerenciador.casadeFamilia.casadeFamilia.model.Funcionaria;
import gerenciador.casadeFamilia.casadeFamilia.model.Reserva;
import jakarta.validation.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;

public abstract class BaseCrudService<
        ENTIDADE extends IEntidade<PK_TYPE>,
        PK_TYPE,
        REPOSITORY extends CrudRepository<ENTIDADE, PK_TYPE>
        > implements CrudService<ENTIDADE, PK_TYPE>{

    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    protected REPOSITORY repository;
    @Override
    public ENTIDADE incluir(ENTIDADE modelo) {
        this.validarCamposObrigatorios(modelo);
        this.validarDados(modelo);
        this.prepararParaIncluir(modelo);
        ENTIDADE entidadeIncluido = this.gravarDados(modelo);
        return entidadeIncluido;
    }

    abstract protected void prepararParaIncluir(ENTIDADE entidade) ;

    private ENTIDADE gravarDados(ENTIDADE entidade) {
        return repository.save(entidade);
    }

    abstract protected  void validarDados(ENTIDADE entidade) ;

    abstract protected void validarCamposObrigatorios(ENTIDADE entidade) ;

    @Override
    public ENTIDADE alterar(ENTIDADE entidade, PK_TYPE id) {
        this.validarCamposObrigatorios(entidade);
        this.validarDados(entidade);

        ENTIDADE entidadeBD = recuperarEntidadeOuGeraErro(id);
        entidade.setId(id);

        try {
            ENTIDADE save = repository.save(entidade);
            return save;
        }catch (ConstraintViolationException | DataIntegrityViolationException cev){
            throw new BusinessException(SistemaMessageCode.ERRO_BD,cev.getMessage());
        }
    }

    protected ENTIDADE recuperarEntidadeOuGeraErro(PK_TYPE id) {
        ENTIDADE entidade = repository
                .findById(id)
                .orElseThrow(
                        () -> new BusinessException(SistemaMessageCode.ERRO_REGISTRO_NAO_ENCONTRADO)
                );
        return entidade;
    }

    @Override
    public ENTIDADE excluir(PK_TYPE id) {
        ENTIDADE entidadeExcluir = this.recuperarEntidadeOuGeraErro(id);
        this.repository.delete(entidadeExcluir);
        return entidadeExcluir;
    }

    @Override
    public ENTIDADE obterPeloId(PK_TYPE id) {
        return this.recuperarEntidadeOuGeraErro(id);
    }

    @Override
    public List<ENTIDADE> listarTodos() {
        return (List<ENTIDADE>) repository.findAll();
    }

//    @Override
//    public List<ENTIDADE> localizar(ENTIDADE ENTIDADE){
//        return this.repository.localizarPorEntidade(ENTIDADE);
//    }
}
