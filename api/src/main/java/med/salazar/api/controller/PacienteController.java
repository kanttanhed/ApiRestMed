package med.salazar.api.controller;

import jakarta.validation.Valid;
import med.salazar.api.domain.domain.Paciente;
import med.salazar.api.domain.dtos.DadosCadastroPaciente;
import med.salazar.api.domain.dtos.DadosListagemPaciente;
import med.salazar.api.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {
    @Autowired
    private PacienteRepository pacienteRepository;

    @GetMapping
    public List<DadosListagemPaciente> listar(){
        return pacienteRepository.findAll().stream().map(DadosListagemPaciente::new).toList();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void cadastrar(@RequestBody @Valid DadosCadastroPaciente dadosCadastroPaciente) {
        pacienteRepository.save(new Paciente(dadosCadastroPaciente));
    }
}
