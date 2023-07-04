package projetofinal.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Inscricao {

    @Id
    private Long id;
    private Double valorInscricao;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private Maratonista maratonista;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private Circuito circuito;
}
