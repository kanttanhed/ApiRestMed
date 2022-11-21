package med.salazar.api.domain.domain;

import jakarta.persistence.*;
import lombok.*;
import med.salazar.api.domain.dtos.DadosCadastroPaciente;

import java.util.UUID;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@Entity(name = "Paciente")
@Table(name = "pacientes")
public class Paciente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String nome;
    @Column(nullable = false)
    private String email;
    @Column(nullable = false)
    private String telefone;
    @Column(nullable = false)
    private String cpf;

    @Embedded
    @Column(nullable = false)
    private Endereco enderecopaciente;

    public Paciente(DadosCadastroPaciente dadosCadastroPaciente){
        this.nome = dadosCadastroPaciente.nome();
        this.email = dadosCadastroPaciente.email();
        this.telefone = dadosCadastroPaciente.telefone();
        this.cpf = dadosCadastroPaciente.cpf();
        this.enderecopaciente = new Endereco(dadosCadastroPaciente.endereco());
    }

}
