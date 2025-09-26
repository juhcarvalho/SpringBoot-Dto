package hogwarts.domain.dtos.response;

import hogwarts.domain.models.NivelFeitico;

public class FeiticoResponseDto {
    private Long id;

    private String nome;

    private NivelFeitico nivel;

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
}
