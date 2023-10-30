package gerenciador.casadeFamilia.api.model;

public interface IEntidade<PK_TYPE> {
    public static final String COMPOSITE_PK_FIELD_NAME ="compositePkEntidadeObject";
    String getTabelaNome();
    PK_TYPE getId();
    PK_TYPE getIdFromHash(String hash);
    void setId(PK_TYPE id);
}
