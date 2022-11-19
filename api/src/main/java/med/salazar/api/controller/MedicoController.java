package med.salazar.api.controller;

import jakarta.validation.Valid;
import med.salazar.api.domain.dtos.DadosCadastroMedico;
import med.salazar.api.domain.dtos.DadosListagemMedico;
import med.salazar.api.domain.entity.Medico;
import med.salazar.api.repository.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/medico")
public class MedicoController {

    @Autowired
    private MedicoRepository medicoRepository;

    @GetMapping
    public List<DadosListagemMedico> listar(){
       return medicoRepository.findAll()
                               .stream()
                               .map(DadosListagemMedico::new)
                               .toList();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Transactional
    public void cadastrar(@RequestBody @Valid DadosCadastroMedico dados) {
        medicoRepository.save(new Medico(dados));
    }
}
