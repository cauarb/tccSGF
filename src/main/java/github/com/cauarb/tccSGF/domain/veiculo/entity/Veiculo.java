package github.com.cauarb.tccSGF.domain.veiculo.entity;


import com.fasterxml.jackson.annotation.JsonBackReference;
import github.com.cauarb.tccSGF.domain.departamento.entity.Departamento;
import jakarta.persistence.*;
import lombok.*;
import org.antlr.v4.runtime.misc.NotNull;

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

    @Column(name = "ano", nullable = false)
    private String ano;

    @Column(name = "kmInicio", nullable = false)
    private Long kmInicio;

    @Column(name = "kmAtual", nullable = false)
    private Long kmAtual;

    @ManyToOne
    @JoinColumn(name = "departamento_id", nullable = false)
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

    public Long getId_Veiculo() {
        return id_Veiculo;
    }

    public void setId_Veiculo(Long id_Veiculo) {
        this.id_Veiculo = id_Veiculo;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }

    public Long getKmInicio() {
        return kmInicio;
    }

    public void setKmInicio(Long kmInicio) {
        this.kmInicio = kmInicio;
    }

    public Long getKmAtual() {
        return kmAtual;
    }

    public void setKmAtual(Long kmAtual) {
        this.kmAtual = kmAtual;
    }

    public Departamento getDepartamento() {
        return departamento;
    }



    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }
}
