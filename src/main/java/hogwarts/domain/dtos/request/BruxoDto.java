package hogwarts.domain.dtos.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

import java.util.List;

public class BruxoDto {

    private Long id;

    @NotBlank(message="Nome é obrigatório")
    @Size(min=3, max=120)
    private String nome;

    @NotEmpty
    private List<Long> feiticoIds;

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

    public List<Long> getFeiticoIds() {
        return feiticoIds;
    }

    public void setFeiticoIds(List<Long> feiticoIds) {
        this.feiticoIds = feiticoIds;
    }
}
