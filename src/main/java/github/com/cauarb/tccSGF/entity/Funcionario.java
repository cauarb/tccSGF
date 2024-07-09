package github.com.cauarb.tccSGF.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Entity
@Table(name = "funcionario")
public class Funcionario {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_Funcionario")
    private Integer id_Funcionario;

    @Column(name = "nome",length = 30, nullable = false)
    private String nome;

    @Column(name = "cargo",length = 30, nullable = false)
    private String cargo;

    @Override
    public String toString() {
        return "Funcionario{" +
                "id_Funcionario=" + id_Funcionario +
                ", nome='" + nome + '\'' +
                ", cargo='" + cargo + '\'' +
                '}';
    }
}
