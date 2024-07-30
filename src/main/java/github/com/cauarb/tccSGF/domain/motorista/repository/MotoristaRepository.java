package github.com.cauarb.tccSGF.domain.motorista.repository;

import github.com.cauarb.tccSGF.domain.motorista.entity.Motorista;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MotoristaRepository extends JpaRepository<Motorista, Long> {
    boolean existsByNome(String nome);
    Optional<Motorista> findByNome(String nome);
}
