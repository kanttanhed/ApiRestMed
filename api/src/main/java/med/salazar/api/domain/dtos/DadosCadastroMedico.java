package med.salazar.api.domain.dtos;

import med.salazar.api.domain.enums.Especialidade;

public record DadosCadastroMedico(String nome, String email, String crm, Especialidade especialidade,
                                  DadosEndereco endereco) {
}