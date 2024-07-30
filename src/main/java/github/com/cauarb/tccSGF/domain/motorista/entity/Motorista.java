package github.com.cauarb.tccSGF.domain.motorista.entity;

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
@Table(name = "motorista")
public class Motorista {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_Motorista")
    private int id_Motorista;

    @Column(name = "nome",length = 30, nullable = false)
    private String nome;

    @Column(name = "cpf",length = 11, nullable = false)
    private String cpf;

    @Column(name = "cnh",length = 30, nullable = false)
    private String cnh;

    @Override
    public String toString() {
        return "Motorista{" +
                "id_Motorista=" + id_Motorista +
                ", nome='" + nome + '\'' +
                ", CPF='" + cpf + '\'' +
                ", cnh='" + cnh + '\'' +
                '}';
    }
}
