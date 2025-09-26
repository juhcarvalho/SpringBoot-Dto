package hogwarts.services;

import hogwarts.domain.dtos.request.FeiticoDto;
import hogwarts.domain.dtos.response.FeiticoResponseDto;

import java.util.List;

public interface FeiticoService {
    List<FeiticoResponseDto> getAll();
    FeiticoResponseDto getById(Long id);
    FeiticoResponseDto create(FeiticoDto feitico);
    FeiticoResponseDto update(Long id, FeiticoDto feitico);
    void delete(Long id);
}
