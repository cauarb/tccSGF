package github.com.cauarb.tccSGF.repository;


import github.com.cauarb.tccSGF.entity.Veiculo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VeiculoRepository extends JpaRepository <Veiculo, Long> {



}
