package gerenciador.casadeFamilia.casadeFamilia.dto;

import lombok.Data;

import java.time.LocalDate;

public @Data  class ReservaDadosAlteravelDTO {

    private String nomeCliente;
    private LocalDate dataReserva;
    private Long funcionaria_id;
}
