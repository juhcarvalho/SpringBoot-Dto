package hogwarts.domain.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Bruxo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 120)
    private String nome;

    @ManyToMany
    @JoinTable(
            name = "bruxo_feitico",
            joinColumns = @JoinColumn(name = "bruxo_id"),
            inverseJoinColumns = @JoinColumn(name = "feitico_id")
    )
    @JsonIgnoreProperties("bruxos")
    private List<Feitico> feiticos;

    public Bruxo() {
    }

    public Bruxo(Long id, String nome, List<Feitico> feiticos) {
        this.id = id;
        this.nome = nome;
        this.feiticos = feiticos;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Feitico> getFeiticos() {
        return feiticos;
    }

    public void setFeiticos(List<Feitico> feiticos) {
        this.feiticos = feiticos;
    }
}
