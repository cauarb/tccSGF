package github.com.cauarb.tccSGF.domain.subDepartamento.repository;

import github.com.cauarb.tccSGF.domain.subDepartamento.entity.SubDepartamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubDepartamentoRepository extends JpaRepository<SubDepartamento, Long> {
}
