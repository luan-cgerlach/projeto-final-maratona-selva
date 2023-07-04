package projetofinal.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Circuito {

    @Id
    private Long id;
    private CategoriaEnum categoria;
    private String distancia;

    @JsonIgnore
    @OneToMany(mappedBy = "circuito", cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE})
    private List<Inscricao> inscricoes;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private MaratonaSelva maratonaSelva;
}
