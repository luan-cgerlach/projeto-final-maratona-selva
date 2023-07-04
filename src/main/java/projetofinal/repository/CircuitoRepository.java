package projetofinal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import projetofinal.entity.Circuito;

@Repository
public interface CircuitoRepository extends JpaRepository<Circuito, Long> {


}
