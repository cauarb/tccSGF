package github.com.cauarb.tccSGF.domain.tipooOleo.repository;

import github.com.cauarb.tccSGF.domain.tipooOleo.entity.TipoOleo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoOleoRepository extends JpaRepository<TipoOleo, Long> {

}
