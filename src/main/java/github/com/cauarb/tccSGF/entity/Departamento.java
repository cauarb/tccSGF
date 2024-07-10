package github.com.cauarb.tccSGF.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.mapping.Set;

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

    @OneToMany(mappedBy = "departamento", cascade = CascadeType.ALL)
    @JoinColumn(name = "id_Veiculo")
    private List<Veiculo> veiculos;

    @Override
    public String toString() {
        return "Departamento{" +
                "id_Departamento=" + id_Departamento +
                ", nome='" + nome_Departamento + '\'' +
                '}';
    }
}
