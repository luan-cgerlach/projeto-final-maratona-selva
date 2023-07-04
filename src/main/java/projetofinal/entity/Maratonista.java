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
    public class Maratonista {

        @Id
        private Long id;
        private String rg;
        private String nome;
        private String sobrenome;
        private Long idade;
        private String numeroCelular;
        private String numeroEmergencia;
        private String grupoSanguineo;

        @JsonIgnore
        @OneToMany(mappedBy = "maratonista", cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE})
        private List<Inscricao> inscricoes;
    }
