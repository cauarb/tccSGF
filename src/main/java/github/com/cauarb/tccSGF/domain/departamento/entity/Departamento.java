package github.com.cauarb.tccSGF.domain.departamento.entity;


import github.com.cauarb.tccSGF.domain.veiculo.entity.Veiculo;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

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
    private Long id_Departamento;

    @Column(name = "nome",length = 30, nullable = false)
    private String nome_Departamento;

    @OneToMany(mappedBy = "departamento")
    private List<Veiculo> veiculos;

    @Override
    public String toString() {
        return "Departamento{" +
                "id_Departamento=" + id_Departamento +
                ", nome='" + nome_Departamento + '\'' +
                '}';
    }
}
