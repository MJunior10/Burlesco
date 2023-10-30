package gerenciador.casadeFamilia.casadeFamilia.model;

import gerenciador.casadeFamilia.api.model.BaseEntidade;
import gerenciador.casadeFamilia.api.model.IEntidade;
import gerenciador.casadeFamilia.api.model.annotation.PkComposite;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import lombok.*;
import org.hibernate.Hibernate;

import java.time.LocalDate;
import java.util.Date;
import java.util.Objects;

import static jakarta.persistence.GenerationType.SEQUENCE;


@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
@PkComposite
@Data
@Table(name = "TBL_FUNCIONARIAS")
public class Funcionaria implements IEntidade<Long> {

    @SequenceGenerator(
            name="a_gerador_sequence",
            sequenceName = "funcionaria_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = SEQUENCE,
            generator = "a_gerador_sequence"
    )
    @Id
    @Column(name="id")
    private Long id;
    @Column(name = "nome", length = 200, nullable = false)
    private String nome;
    @Column(name="apelido", length = 200, nullable = false)
    private String apelido;
    @Column(name = "especialidade", length = 300)
    private String especialidade;
    @Column(name="supervisor",length = 200, nullable = false)
    private String supervisor;
    @Min(100)
    @Column(name="Valor", nullable = false)
    private Float valorAtendimento;
    @Column(name = "Nascimento", nullable = false)
    private LocalDate dataNascimento;

    @Override
    public String getTabelaNome() {
        return "funcionarias";
    }

    @Override
    public Long getIdFromHash(String hash) {
        return null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Funcionaria funcionaria = (Funcionaria) o;
        return id != null && Objects.equals(id, funcionaria.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}