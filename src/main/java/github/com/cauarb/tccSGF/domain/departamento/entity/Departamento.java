package github.com.cauarb.tccSGF.domain.departamento.entity;


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
    private Long id_Departamento;

    @Column(name = "nome",length = 30, nullable = false)
    private String nome;

    @OneToMany(mappedBy = "departamento")
    private List<Veiculo> veiculos;

    @Override
    public String toString() {
        return "Departamento{" +
                "id_Departamento=" + id_Departamento +
                ", nome='" + nome + '\'' +
                '}';
    }

    public Long getId_Departamento() {
        return id_Departamento;
    }

    public void setId_Departamento(Long id_Departamento) {
        this.id_Departamento = id_Departamento;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Veiculo> getVeiculos() {
        return veiculos;
    }

    public void setVeiculos(List<Veiculo> veiculos) {
        this.veiculos = veiculos;
    }
}
