package med.salazar.api.controller;

import jakarta.validation.Valid;
import med.salazar.api.domain.dtos.DadosAtualizacaoMedico;
import med.salazar.api.domain.dtos.DadosCadastroMedico;
import med.salazar.api.domain.dtos.DadosDetalhamentoMedico;
import med.salazar.api.domain.dtos.DadosListagemMedico;
import med.salazar.api.domain.entity.Medico;
import med.salazar.api.domain.repository.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/medico")
public class MedicoController {

    @Autowired
    private MedicoRepository medicoRepository;

    @GetMapping
    public ResponseEntity<Page<DadosListagemMedico>> listar(@PageableDefault(size = 10, sort = {"nome"}) Pageable pagina){
       var page = medicoRepository.findAllByAtivoTrue(pagina).map(medico -> new DadosListagemMedico(medico));
       return ResponseEntity.ok(page);
    }
    @GetMapping("/{medicoId}")
    public ResponseEntity listarPorId(@PathVariable Long medicoId){
        var medico = medicoRepository.getReferenceById(medicoId);
        return ResponseEntity.ok(new DadosDetalhamentoMedico(medico));
    }

    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid DadosCadastroMedico dados,
                                    UriComponentsBuilder uriComponentsBuilder) {

        var medico = new Medico(dados);
        medicoRepository.save(medico);

        //var uri =uriComponentsBuilder.path("/medicos/{id}").buildAndExpand(medico.getId()).toUri();
        //return ResponseEntity.created(uri).body(new DadosDetalhamentoMedico(medico));

        URI headerLocation = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .query("id={id}")
                .buildAndExpand(medico.getId())
                .toUri();
        return ResponseEntity.created(headerLocation).body(new DadosDetalhamentoMedico(medico));
    }

    @PutMapping
    @Transactional
    public ResponseEntity atualizar(@RequestBody @Valid DadosAtualizacaoMedico dados){
        var medico= medicoRepository.getReferenceById(dados.id());
        medico.atualizarInformacao(dados);
        return ResponseEntity.ok(new DadosDetalhamentoMedico(medico));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity excluir(@PathVariable Long id){
        var medico= medicoRepository.getReferenceById(id);
        medico.excluir();
        return ResponseEntity.noContent().build();
    }
}
