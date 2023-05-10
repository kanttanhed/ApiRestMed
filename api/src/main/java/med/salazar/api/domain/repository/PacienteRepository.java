package med.salazar.api.domain.repository;


import med.salazar.api.domain.entity.Paciente;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;


public interface PacienteRepository extends JpaRepository<Paciente, Long> {

    Page<Paciente> findAllByAtivoTrue(Pageable pagina);
}
