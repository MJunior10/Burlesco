package gerenciador.casadeFamilia.casadeFamilia.repository.impl;

import gerenciador.casadeFamilia.casadeFamilia.model.Funcionaria;
import gerenciador.casadeFamilia.casadeFamilia.model.Reserva;
import gerenciador.casadeFamilia.casadeFamilia.repository.FuncionariaRepositoryCustom;
import gerenciador.casadeFamilia.casadeFamilia.repository.ReservaRepositoryCustom;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class ReservaRepositoryImpl implements ReservaRepositoryCustom {

    @Autowired
    private EntityManager entityManager;

    @Override
    public List<Reserva> localizarPorReserva(Reserva reserva) {
        Map<String, Object> parametros = new HashMap<>();
        StringBuilder jpql = new StringBuilder();
        jpql.append(" SELECT reserva FROM Reserva reserva");

        jpql.append(" WHERE 1=1 ");

        if (Strings.isNotEmpty(reserva.getNomeCliente())) {
            jpql.append(" AND UPPER(reserva.nomeCliente) LIKE UPPER('%' || :nomeCliente || '%')  ");
            parametros.put("nomeCliente", reserva.getNomeCliente());
        }
        if(Objects.nonNull(reserva.getDataReserva()))
        {
            jpql.append(("AND reserva.dataReserva = :dataReserva "));
            parametros.put("dataReserva", reserva.getDataReserva());
        }

        TypedQuery<Reserva> query = entityManager.createQuery(jpql.toString(), Reserva.class);
        parametros.entrySet().forEach(parametro -> query.setParameter(parametro.getKey(), parametro.getValue()));
        return query.getResultList();
    }
}
