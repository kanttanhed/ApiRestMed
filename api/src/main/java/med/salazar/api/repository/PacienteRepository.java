package med.salazar.api.repository;


import med.salazar.api.domain.domain.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PacienteRepository extends JpaRepository<Paciente, Long> {
}
