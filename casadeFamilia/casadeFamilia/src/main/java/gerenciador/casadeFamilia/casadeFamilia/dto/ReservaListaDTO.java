package gerenciador.casadeFamilia.casadeFamilia.dto;

import lombok.Data;

import java.time.LocalDate;

public @Data class ReservaListaDTO {
    private Long id;
    private String nomeCliente;
    private LocalDate dataReserva;
    private Long funcionaria_id;

}
