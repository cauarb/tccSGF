package github.com.cauarb.tccSGF.domain.departamento.entity;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import github.com.cauarb.tccSGF.domain.veiculo.entity.Veiculo;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Entity
@Table(name = "departamento")
public class Departamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_Departamento")
    private Long id;

    @Column(name = "nome",length = 30, nullable = false)
    private String nome;

    @Override
    public String toString() {
        return "Departamento{" +
                "id_Departamento=" + id +
                ", nome='" + nome + '\'' +
                '}';
    }

}
