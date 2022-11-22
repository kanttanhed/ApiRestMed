package med.salazar.api.domain.domain;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import med.salazar.api.domain.dtos.DadosCadastroPaciente;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "pacientes")
@NoArgsConstructor
public class Paciente {

    @Id
    @EqualsAndHashCode.Include
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
