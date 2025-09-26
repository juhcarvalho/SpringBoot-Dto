package hogwarts.domain.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Feitico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 120)
    private String nome;

    @Enumerated(EnumType.STRING)
    private NivelFeitico nivel;

    @ManyToMany(mappedBy = "feiticos")
    @JsonIgnoreProperties("feiticos")
    private List<Bruxo> bruxos;

    public Feitico() {
    }

    public Feitico(Long id, String nome, NivelFeitico nivel, List<Bruxo> bruxos) {
        this.id = id;
        this.nome = nome;
        this.nivel = nivel;
        this.bruxos = bruxos;
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

    public NivelFeitico getNivel() {
        return nivel;
    }

    public void setNivel(NivelFeitico nivel) {
        this.nivel = nivel;
    }

    public List<Bruxo> getBruxos() {
        return bruxos;
    }

    public void setBruxos(List<Bruxo> bruxos) {
        this.bruxos = bruxos;
    }
}
