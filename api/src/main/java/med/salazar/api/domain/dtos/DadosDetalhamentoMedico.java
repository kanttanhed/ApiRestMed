package med.salazar.api.domain.dtos;

import med.salazar.api.domain.entity.Endereco;
import med.salazar.api.domain.entity.Medico;
import med.salazar.api.domain.enums.Especialidade;

public record DadosDetalhamentoMedico(Long id, String nome, String email, String crm, String telefone,
                                      Especialidade especialidade, Endereco endereco) {

    public DadosDetalhamentoMedico(Medico medico) {
        this(medico.getId(), medico.getNome(), medico.getEmail(), medico.getCrm(), medico.getTelefone(),
                medico.getEspecialidade(), medico.getEndereco());
    }
}