package gerenciador.casadeFamilia.casadeFamilia.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@Builder
@AllArgsConstructor
@NoArgsConstructor

public @Data class ReservaDTO {
    private Long id;
    private String nomeCliente;
    private LocalDate dataReserva;
    private Long funcionaria_id;
}
