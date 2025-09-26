package hogwarts.controllers;

import hogwarts.domain.dtos.request.FeiticoDto;
import hogwarts.domain.dtos.response.FeiticoResponseDto;
import hogwarts.services.FeiticoService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("feitico")
public class FeiticoController {
    private final FeiticoService service;

    public FeiticoController(FeiticoService service) {
        this.service = service;
    }

    @GetMapping
    public List<FeiticoResponseDto> listarTodos(){
        return service.getAll();
    }

    @PostMapping
    public FeiticoResponseDto cadastrar(@RequestBody @Valid FeiticoDto dto){
        return service.create(dto);
    }

    @PostMapping("/{id}")
    public FeiticoResponseDto atualizar(@PathVariable Long id, @RequestBody @Valid FeiticoDto dto){
        return service.update(id, dto);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id){
        service.delete(id);
    }
}
