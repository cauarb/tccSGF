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
@Table(name = "veiculo")
public class Veiculo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_Veiculo")
    private Long id_Veiculo;

    @Column(name = "placa",length = 30, nullable = false)
    private String placa;

    @Column(name = "modelo",length = 30, nullable = false)
    private String modelo;

    @Column(name = "marca",length = 30, nullable = false)
    private String marca;

    @Column(name = "ano",length = 30, nullable = false)
    private String ano;

    @Column(name = "kmInicio",length = 30, nullable = false)
    private Float kmInicio;

    @Column(name = "kmAtual",length = 30, nullable = false)
    private Float kmAtual;

    @OneToOne(mappedBy = "departamento", cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "id_Deparmento")
    private Departamento departamento;

    @Override
    public String toString() {
        return "Veiculo{" +
                "id_Veiculo=" + id_Veiculo +
                ", placa='" + placa + '\'' +
                ", modelo='" + modelo + '\'' +
                ", marca='" + marca + '\'' +
                ", ano='" + ano + '\'' +
                ", kmInicio=" + kmInicio +
                ", kmAtual=" + kmAtual +
                '}';
    }
}
