package bada_bdbt_proj;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdresRepository extends JpaRepository<Adres,Long> {
}
