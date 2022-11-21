package med.salazar.api.domain.dtos;

import med.salazar.api.domain.domain.Endereco;
import med.salazar.api.domain.domain.Paciente;

import java.util.UUID;

public record DadosListagemPaciente(Long id, String nome, String email,
                                    String telefone, String cpf, Endereco endereco) {

    public DadosListagemPaciente(Paciente paciente){
        this(paciente.getId(),
                paciente.getNome(),
                paciente.getEmail(),
                paciente.getTelefone(),
                paciente.getCpf(),
                paciente.getEnderecopaciente());
    }
}
