package hogwarts.domain.dtos.response;

import java.util.List;

public class BruxoResponseDTO {
    private Long id;

    private String nome;

    private List<FeiticoResumidoResponseDTO> feiticos;

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

    public List<FeiticoResumidoResponseDTO> getFeiticos() {
        return feiticos;
    }

    public void setFeiticos(List<FeiticoResumidoResponseDTO> feiticos) {
        this.feiticos = feiticos;
    }
}
