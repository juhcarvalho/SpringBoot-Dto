package hogwarts.services;

import hogwarts.domain.dtos.request.BruxoDto;
import hogwarts.domain.dtos.response.BruxoResponseDTO;
import hogwarts.domain.dtos.response.FeiticoResumidoResponseDTO;
import hogwarts.domain.models.Bruxo;
import hogwarts.domain.models.Feitico;
import hogwarts.exceptions.ResourceNotFoundException;
import hogwarts.repositories.BruxoRepository;
import hogwarts.repositories.FeiticoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class BruxoServiceImpl implements BruxoService{
    private final BruxoRepository bruxoRepository;
    private final FeiticoRepository feiticoRepository;

    public BruxoServiceImpl(BruxoRepository bruxoRepository, FeiticoRepository feiticoRepository) {
        this.bruxoRepository = bruxoRepository;
        this.feiticoRepository = feiticoRepository;
    }

    @Override
    public List<BruxoResponseDTO> getAll(){
        return bruxoRepository.findAll().stream().map(this::toResponseDto).collect(Collectors.toList());
    }

    @Override
    public BruxoResponseDTO getById(Long id){
        Bruxo bruxo = bruxoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Bruxo  com o id " + id + " não encontrado"));
        return toResponseDto(bruxo);
    }

    @Override
    public BruxoResponseDTO create(BruxoDto dto) {
        List<Feitico> feiticos = feiticoRepository.findAllById(dto.getFeiticoIds());
        Bruxo entity = toEntity(dto);
        entity.setFeiticos(feiticos);
        return toResponseDto(bruxoRepository.save(entity));
    }

    @Override
    public BruxoResponseDTO update(Long id, BruxoDto dto) {

        //Conversão do DTO para Entity
        List<Feitico> feiticos = feiticoRepository.findAllById(dto.getFeiticoIds());
        Bruxo entity = toEntity(dto);
        entity.setId(id);
        entity.setFeiticos(feiticos);

        return toResponseDto(bruxoRepository.save(entity));
    }

    @Override
    public void delete(Long id) {
        bruxoRepository.deleteById(id);
    }

    private BruxoDto toDto(Bruxo entity){
        BruxoDto dto = new BruxoDto();
        dto.setId(entity.getId());
        dto.setNome(entity.getNome());
        return dto;
    }

    private BruxoResponseDTO toResponseDto(Bruxo entity){
        BruxoResponseDTO dto = new BruxoResponseDTO();
        dto.setNome(entity.getNome());
        dto.setId(entity.getId());

        List<FeiticoResumidoResponseDTO> feiticos = entity.getFeiticos()
                .stream()
                .map(f -> new FeiticoResumidoResponseDTO(f.getId(), f.getNome()))
                .collect(Collectors.toList());

        dto.setFeiticos(feiticos);
        return dto;
    }

    private Bruxo toEntity(BruxoDto dto){
        Bruxo entity = new Bruxo();
        entity.setNome(dto.getNome());
        return entity;
    }
}
