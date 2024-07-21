package github.com.cauarb.tccSGF.domain.veiculo.repository;


import github.com.cauarb.tccSGF.domain.veiculo.entity.Veiculo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VeiculoRepository extends JpaRepository <Veiculo, Long> {

}
