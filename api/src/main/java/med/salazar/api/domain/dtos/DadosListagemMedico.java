package med.salazar.api.domain.dtos;

import med.salazar.api.domain.entity.Medico;
import med.salazar.api.domain.enums.Especialidade;

public record DadosListagemMedico(String nome, String email, String crm, Especialidade especialidade) {

    public DadosListagemMedico(Medico medico){
        this(medico.getNome(), medico.getEmail(), medico.getCrm(), medico.getEspecialidade());
    }
}
