package med.salazar.api.controller;

import jakarta.validation.Valid;
import med.salazar.api.domain.domain.Paciente;
import med.salazar.api.domain.dtos.DadosCadastroPaciente;
import med.salazar.api.domain.dtos.DadosListagemPaciente;
import med.salazar.api.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {
    @Autowired
    private PacienteRepository pacienteRepository;

    @GetMapping
    public Page<DadosListagemPaciente> listar(@PageableDefault(size = 10, sort = {"nome"}) Pageable pagina){
        return pacienteRepository.findAll(pagina).map(DadosListagemPaciente::new);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void cadastrar(@RequestBody @Valid DadosCadastroPaciente dadosCadastroPaciente) {
        pacienteRepository.save(new Paciente(dadosCadastroPaciente));
    }
}
