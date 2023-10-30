package gerenciador.casadeFamilia.casadeFamilia.repository;

import gerenciador.casadeFamilia.api.repository.CrudRepository;
import gerenciador.casadeFamilia.casadeFamilia.model.Funcionaria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FuncionariaRepository extends CrudRepository<Funcionaria> {

}
