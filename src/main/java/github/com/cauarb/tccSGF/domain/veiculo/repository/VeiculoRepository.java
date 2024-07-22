package github.com.cauarb.tccSGF.domain.veiculo.repository;


import github.com.cauarb.tccSGF.domain.veiculo.entity.Veiculo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface VeiculoRepository extends JpaRepository <Veiculo, Long> {

    boolean existsByPlaca(String placa);
    Optional<Veiculo> findByPlaca(String placa);
    List<Veiculo> findByDepartamentoNome(String nome);
}
