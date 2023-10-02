package gerenciador.casadeFamilia.api.exception;

import java.io.Serial;

/**
 * Classe de exceção a ser lançada caso seja identificado parâmetros inválidos.
 *
 * @author UEG
 */
public class InvalidParameterException extends RuntimeException {

    @Serial
    private static final long serialVersionUID = 6477399315270679560L;

    private final String field;

    private final String defaultMessage;

    /**
     * Construtor da classe.
     *
     * @param field Field
     * @param defaultMessage Mensagem Padrão de erro
     */
    public InvalidParameterException(final String field, final String defaultMessage) {
        this.field = field;
        this.defaultMessage = defaultMessage;
    }

    /**
     * @return the field
     */
    public String getField() {
        return field;
    }

    /**
     * @return the defaultMessage
     */
    public String getDefaultMessage() {
        return defaultMessage;
    }

    /**
     * @see Throwable#getMessage()
     */
    @Override
    public String getMessage() {
        return defaultMessage;
    }
}
