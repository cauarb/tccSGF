package github.com.cauarb.tccSGF.domain.motorista.repository;

import github.com.cauarb.tccSGF.domain.motorista.entity.Motorista;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MotoristaRepository extends JpaRepository<Motorista, Long> {

}
