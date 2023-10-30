package gerenciador.casadeFamilia.api.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.v3.oas.annotations.Hidden;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Schema(description = "Representação de Credencial do Usuário")
@Builder
public @Data class CredencialRegisterDTO {
    private static final long serialVersionUID = 7616722014159043532L;

    @Schema(description = "Id do Usuário")
    @Hidden
    private Long id;

    @Schema(description = "Nome do Usuário")
    private String nome;

    @Schema(description = "Login do Usuário")
    private String login;

    @Schema(description = "Email do Usário")
    private String email;

    @Schema(description = "Indica se o usuário está ativo")
    private boolean statusAtivo;

    @Schema(description = "Senha do usuário")
    private String senha;
}
