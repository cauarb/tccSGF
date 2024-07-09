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
@Table(name = "cidade")
public class Cidade {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_Cidade")
    private int id_Cidade;

    @Column(name = "nome",length = 30, nullable = false)
    private String nome_Cidade;

    @Column(name = "nome",length = 30, nullable = false)
    private String estado;

    @Override
    public String toString() {
        return "Cidades{" +
                "id_Cidade=" + id_Cidade +
                ", nome='" + nome_Cidade + '\'' +
                ", estado='" + estado + '\'' +
                '}';
    }

}