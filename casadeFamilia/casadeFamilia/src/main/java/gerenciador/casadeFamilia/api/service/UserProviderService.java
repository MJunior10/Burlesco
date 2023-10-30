package gerenciador.casadeFamilia.api.service;


import gerenciador.casadeFamilia.api.dto.CredencialDTO;
import gerenciador.casadeFamilia.api.dto.UsuarioSenhaDTO;

public interface UserProviderService {
    CredencialDTO getCredentialByLogin(String username);
    CredencialDTO redefinirSenha(UsuarioSenhaDTO usuarioSenhaDTO);
    CredencialDTO getCredentialByEmail(String email);
}
