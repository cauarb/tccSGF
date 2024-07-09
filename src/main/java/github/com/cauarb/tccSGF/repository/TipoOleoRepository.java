package github.com.cauarb.tccSGF.repository;

import github.com.cauarb.tccSGF.entity.TipoOleo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoOleoRepository extends JpaRepository<TipoOleo, Long> {

}
