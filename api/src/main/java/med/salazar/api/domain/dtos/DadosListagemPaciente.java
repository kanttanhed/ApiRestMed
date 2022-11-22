package med.salazar.api.domain.dtos;

import med.salazar.api.domain.domain.Endereco;
import med.salazar.api.domain.domain.Paciente;

import java.util.UUID;

public record DadosListagemPaciente(String nome, String email, String cpf) {

    public DadosListagemPaciente(Paciente paciente){
        this(paciente.getNome(), paciente.getEmail(), paciente.getCpf());
    }
}
