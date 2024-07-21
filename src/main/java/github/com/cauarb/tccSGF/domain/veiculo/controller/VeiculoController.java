package github.com.cauarb.tccSGF.domain.veiculo.controller;

import github.com.cauarb.tccSGF.domain.veiculo.entity.Veiculo;
import github.com.cauarb.tccSGF.domain.veiculo.repository.VeiculoRepository;
import github.com.cauarb.tccSGF.domain.veiculo.service.VeiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/veiculo")
public class VeiculoController {

    @Autowired
    private VeiculoRepository veiculoRepository;

    @Autowired
    private VeiculoService veiculoService;

    @PostMapping
    public ResponseEntity<Veiculo> criaVeiculo(@Validated @RequestBody Veiculo novoVeiculo) {
        try {
            Veiculo veiculoSalvo = veiculoService.cadastrarVeiculo(novoVeiculo);
            return new ResponseEntity<>(veiculoSalvo, HttpStatus.CREATED);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("{id}")
    public Veiculo acharPorId(@PathVariable Long id){
        return veiculoRepository.findById(id).orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Veiculo não encontrado") );
    }

    @GetMapping
    public List<Veiculo> listarVeiculo() {
        return veiculoRepository.findAll();
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        veiculoRepository.deleteById(id);
    }

    @PutMapping("/{id}")
    public void editar(@PathVariable Long id, @RequestBody Veiculo veiculoAtualizado) {
        Veiculo veiculoExistente = veiculoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Veiculo nao encontrado: " + id));

        veiculoExistente.setPlaca(veiculoAtualizado.getPlaca());
        veiculoExistente.setModelo(veiculoAtualizado.getModelo());
        veiculoExistente.setMarca(veiculoAtualizado.getMarca());
        veiculoExistente.setAno(veiculoAtualizado.getAno());
        veiculoExistente.setKmInicio(veiculoAtualizado.getKmInicio());
        veiculoExistente.setKmAtual(veiculoAtualizado.getKmAtual());
        veiculoExistente.setDepartamento(veiculoAtualizado.getDepartamento());

        veiculoRepository.save(veiculoExistente);
    }


}
