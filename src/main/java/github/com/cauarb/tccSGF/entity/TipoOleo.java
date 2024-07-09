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
@Table(name ="tipoOleo")
public class TipoOleo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_Oleo")
    private int id_Oleo;

    @Column(name = "placa",length = 30, nullable = false)
    private String nome_Oleo;

    @Override
    public String toString() {
        return "TipoOleo{" +
                "id_Oleo=" + id_Oleo +
                ", nome='" + nome_Oleo + '\'' +
                '}';
    }
}
