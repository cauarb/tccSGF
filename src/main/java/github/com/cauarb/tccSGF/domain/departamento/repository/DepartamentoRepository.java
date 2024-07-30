package github.com.cauarb.tccSGF.domain.departamento.repository;

import github.com.cauarb.tccSGF.domain.departamento.entity.Departamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DepartamentoRepository extends JpaRepository<Departamento, Long> {
    List<Departamento> findByNomeContaining(String nome);
    Optional<Departamento> findByNome(String nome);
}
