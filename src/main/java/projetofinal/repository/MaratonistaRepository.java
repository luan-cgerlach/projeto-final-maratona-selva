package projetofinal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import projetofinal.entity.Maratonista;

@Repository
public interface MaratonistaRepository extends JpaRepository<Maratonista, Long> {

}
