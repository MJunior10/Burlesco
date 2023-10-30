/*
 * Credential.java
 * Copyright (c) UEG.
 *
 *
 *
 *
 */
package gerenciador.casadeFamilia.api.security;

import java.util.List;

/**
 * Interface de contrato referente a credencial padrão da UEG, para a
 * comunicação entre os diversos 'clients' de Microserviço.
 *
 * @author UEG
 */
public interface Credential {

    /**
     * Returns the username logged in.
     *
     * @return -
     */
    public String getLogin();

    /**
     * Returns the roles logged in.
     *
     * @return -
     */
    public List<String> getRoles();

    /**
     * Returns the logged in user's access token.
     *
     * @return -
     */
    public String getAccessToken();

}