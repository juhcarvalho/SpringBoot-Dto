package hogwarts.services;

import hogwarts.domain.dtos.request.BruxoDto;
import hogwarts.domain.dtos.response.BruxoResponseDTO;

import java.util.List;

public interface BruxoService {
    List<BruxoResponseDTO> getAll();
    BruxoResponseDTO getById(Long id);
    BruxoResponseDTO create(BruxoDto bruxo);
    BruxoResponseDTO update(Long id, BruxoDto bruxo);
    void delete(Long id);
}
