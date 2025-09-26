package hogwarts.services;

import hogwarts.domain.dtos.request.FeiticoDto;
import hogwarts.domain.dtos.response.FeiticoResponseDto;
import hogwarts.domain.models.Feitico;
import hogwarts.exceptions.ResourceNotFoundException;
import hogwarts.repositories.FeiticoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FeiticoServiceImpl implements FeiticoService{
    private final FeiticoRepository repository;

    public FeiticoServiceImpl(FeiticoRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<FeiticoResponseDto> getAll() {
        return repository.findAll().stream().map(this::toResponseDto).collect(Collectors.toList());
    }

    @Override
    public FeiticoResponseDto getById(Long id) {
        Feitico entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Feitico  com o id " + id + " não encontrado"));
        return toResponseDto(entity);
    }

    @Override
    public FeiticoResponseDto create(FeiticoDto dto) {
        Feitico entity = toEntity(dto);
        return toResponseDto(repository.save(entity));
    }

    @Override
    public FeiticoResponseDto update(Long id, FeiticoDto dto) {
        repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Feitico com o id " + id + " não encontrado"));

        //Conversão do DTO para Entity
        Feitico entity = toEntity(dto);
        entity.setId(id);
        entity = repository.save(entity);
        return toResponseDto(entity);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    private FeiticoDto toDto(Feitico entity){
        FeiticoDto dto = new FeiticoDto();
        dto.setId(entity.getId());
        dto.setNome(entity.getNome());
        dto.setNivel(entity.getNivel());
        return dto;
    }

    private FeiticoResponseDto toResponseDto(Feitico entity){
        FeiticoResponseDto dto = new FeiticoResponseDto();
        dto.setId(entity.getId());
        dto.setNome(entity.getNome());
        dto.setNivel(entity.getNivel());
        return dto;
    }

    private Feitico toEntity(FeiticoDto dto){
        Feitico entity = new Feitico();
        entity.setNome(dto.getNome());
        entity.setNivel(dto.getNivel());
        return entity;
    }
}
