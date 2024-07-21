package github.com.cauarb.tccSGF.domain.cidade.repository;

import github.com.cauarb.tccSGF.domain.cidade.entity.Cidade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CidadeRepository extends JpaRepository<Cidade, Long> {

}
