package med.salazar.api.domain.dtos;

import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoMedico(@NotNull Long id, String nome, String telefone, DadosEndereco endereco) {
}
