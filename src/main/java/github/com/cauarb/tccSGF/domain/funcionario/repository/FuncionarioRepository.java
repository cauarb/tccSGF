package github.com.cauarb.tccSGF.domain.funcionario.repository;

import github.com.cauarb.tccSGF.domain.funcionario.entity.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {

}
