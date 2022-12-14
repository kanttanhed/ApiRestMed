package med.salazar.api.controller;

import jakarta.validation.Valid;
import med.salazar.api.domain.dtos.DadosAtualizacaoMedico;
import med.salazar.api.domain.dtos.DadosCadastroMedico;
import med.salazar.api.domain.dtos.DadosListagemMedico;
import med.salazar.api.domain.domain.Medico;
import med.salazar.api.repository.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/medico")
public class MedicoController {

    @Autowired
    private MedicoRepository medicoRepository;

    @GetMapping
    public Page<DadosListagemMedico> listar(@PageableDefault(size = 10, sort = {"nome"}) Pageable pagina){
       return medicoRepository.findAllByAtivoTrue(pagina).map(DadosListagemMedico::new);
    }
    @GetMapping("/{medicoId}")
    public Optional<DadosListagemMedico> listarPorId(@PathVariable Long medicoId){
        return medicoRepository.findById(medicoId).map(DadosListagemMedico::new);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Transactional
    public void cadastrar(@RequestBody @Valid DadosCadastroMedico dados) {
        medicoRepository.save(new Medico(dados));
    }

    @PutMapping
    @Transactional
    public void atualizar(@RequestBody @Valid DadosAtualizacaoMedico dados){
        var medico= medicoRepository.getReferenceById(dados.id());
        medico.atualizarInformacao(dados);
    }
    @DeleteMapping("/{id}")
    @Transactional
    public void excluir(@PathVariable Long id){
        var medico= medicoRepository.getReferenceById(id);
        medico.excluir();
    }
}
