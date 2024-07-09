package github.com.cauarb.tccSGF.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "subdepartamento")
public class SubDepartamento {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_subDepartamento")
    private int id_subDepartamento;

    @Column(name = "nome",length = 30, nullable = false)
    private String nome_subDepartamento;

    @OneToOne
    private Departamento departamento;

    @Override
    public String toString() {
        return "SubDepartamento{" +
                "id_subDeparmento=" + id_subDepartamento +
                ", nome='" + nome_subDepartamento + '\'' +
                ", departamento=" + departamento +
                '}';
    }
}
