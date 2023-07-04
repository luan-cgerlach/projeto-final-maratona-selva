package projetofinal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import projetofinal.entity.MaratonaSelva;

@Repository
public interface MaratonaSelvaRepository extends JpaRepository<MaratonaSelva, Long> {

}
