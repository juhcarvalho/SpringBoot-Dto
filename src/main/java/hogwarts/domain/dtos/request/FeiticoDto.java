package hogwarts.domain.dtos.request;

import hogwarts.domain.models.NivelFeitico;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.List;

public class FeiticoDto {
    private Long id;

    @NotBlank(message = "Nome é obrigatório")
    @Size(min=3, max=120)
    private String nome;

    private NivelFeitico nivel;

    private List<Long> bruxoIds;

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

    public List<Long> getBruxoIds() {
        return bruxoIds;
    }

    public void setBruxoIds(List<Long> bruxoIds) {
        this.bruxoIds = bruxoIds;
    }
}
