package gerenciador.casadeFamilia.api.model;

public interface IEntidade<PK_TYPE> {
    String getTabelaNome();
    PK_TYPE getId();
    void setId(PK_TYPE id);
}
