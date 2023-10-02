package gerenciador.casadeFamilia.api.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class Util {


    public static final Long TAMANHO_CPF = 11L;

    private static final String IE_ZERO = "00000000000";

    private static final String CPF_ZERO = "00000000000";

    private static final String CNPJ_ZERO = "00000000000000";

    /**
     * Construtor privado para garantir o singleton.
     */
    private Util() {

    }

    /**
     * Verifica se o valor informado está vazio.
     *
     * @param value
     * @return
     */
    public static boolean isEmpty(final String value) {
        return StringUtils.isEmpty(value);
    }

    /**
     * Remove os caracteres não numéricos do 'valor' informado.
     *
     * @param valor
     * @return
     */
    public static String removerCaracteresNaoNumericos(String valor) {

        if (!Util.isEmpty(valor)) {
            valor = valor.replaceAll("[^\\d]", "");
        }
        return valor;
    }

    /**
     * Retorna a string com os dados do array de objetos concatenados conforme o
     * separador informado.
     *
     * @param separador
     * @param parametros
     * @return
     */
    public static String getValorConcatenado(final String separador, Object... parametros) {
        return Util.getValorConcatenado(separador, Arrays.asList(parametros));
    }

    /**
     * Retorna a string com os dados da {@link List} concatenados conforme o
     * separador informado.
     *
     * @param separador
     * @param parametros
     * @return
     */
    public static String getValorConcatenado(final String separador, final List<Object> parametros) {
        StringBuilder build = new StringBuilder();
        Iterator<?> iterator = parametros.iterator();

        while (iterator.hasNext()) {
            Object valor = iterator.next().toString();
            build.append(valor);

            if (iterator.hasNext()) {
                build.append(separador);
            }
        }
        return build.toString();
    }

    /**
     * Retorna o e-mail obfuscado no seguinte modelo 3 primeiras
     * letras antes do @ e demais obfuscadas com ***
     *
     * @param email
     * @return
     */
    public static String getEmailObfuscado(final String email) {
        return email.replaceAll("(^[^@]{3}|(?!^)\\G)[^@]", "$1*");
    }

    /**
     * Retorna o map serializado no formato json.
     *
     * @param data
     * @return
     */
    public static String toJson(final Map<String, Object> data) {
        String json = "";

        try {
            json = new ObjectMapper().writeValueAsString(data);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return json;
    }
}
