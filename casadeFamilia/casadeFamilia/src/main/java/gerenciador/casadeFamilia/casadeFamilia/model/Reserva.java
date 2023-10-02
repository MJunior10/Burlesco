package gerenciador.casadeFamilia.casadeFamilia.model;


import gerenciador.casadeFamilia.api.model.IEntidade;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.Hibernate;

import java.time.LocalDate;
import java.util.Objects;

import static jakarta.persistence.GenerationType.SEQUENCE;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
@Data
@Table(name = "TBL_RESERVA")

public class Reserva implements IEntidade<Long> {
    @SequenceGenerator(
            name="a_gerador_sequence",
            sequenceName = "reserva_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = SEQUENCE,
            generator = "a_gerador_sequence"
    )
    @Id
    @Column(name="id")
    private Long id;
    @Column(name = "nomeCliente", length = 200, nullable = false)
    private String nomeCliente;
    @Column(name = "dataReserva", nullable = false)
    private LocalDate dataReserva;

    @ManyToOne
    @JoinColumn( name = "funcionaria_id", referencedColumnName = "id", nullable = false, foreignKey = @ForeignKey(name = "fk_funcionaria_reserva"))
    private Funcionaria funcionaria;

    @Override
    public String getTabelaNome() {
        return "reservas";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Reserva reserva = (Reserva) o;
        return id != null && Objects.equals(id, reserva.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}