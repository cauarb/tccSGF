package github.com.cauarb.tccSGF.domain.departamento.repository;

import github.com.cauarb.tccSGF.domain.departamento.entity.Departamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartamentoRepository extends JpaRepository<Departamento, Long> {


}
