package med.salazar.api.repository;

import med.salazar.api.domain.entity.Medico;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicoRepository extends JpaRepository<Medico, Long> {


}
