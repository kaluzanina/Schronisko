package bada_bdbt_proj;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KlientRepository extends JpaRepository<Klient, Long> {
    // You can add custom query methods here if needed
}