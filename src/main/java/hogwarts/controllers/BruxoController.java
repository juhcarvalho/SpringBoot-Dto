package hogwarts.controllers;

import hogwarts.domain.dtos.request.BruxoDto;
import hogwarts.domain.dtos.response.BruxoResponseDTO;
import hogwarts.services.BruxoService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bruxo")
public class BruxoController {
    private final BruxoService service;

    public BruxoController(BruxoService service) {
        this.service = service;
    }

    @GetMapping
    public List<BruxoResponseDTO> listarTodos(){
        return service.getAll();
    }

    @PostMapping
    public BruxoResponseDTO cadastrar(@RequestBody @Valid BruxoDto bruxo){
        return service.create(bruxo);
    }

    @PostMapping("/{id}")
    public BruxoResponseDTO atualizar(@PathVariable Long id, @RequestBody @Valid BruxoDto bruxo){
        return service.update(id, bruxo);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id){
        service.delete(id);
    }
}
