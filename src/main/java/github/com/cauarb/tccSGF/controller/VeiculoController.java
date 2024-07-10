package github.com.cauarb.tccSGF.controller;

import github.com.cauarb.tccSGF.entity.Veiculo;
import github.com.cauarb.tccSGF.repository.VeiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/veiculo")
public class VeiculoController {

    @Autowired
    private VeiculoRepository veiculoRepository;

    @PostMapping
    public ResponseEntity<Veiculo> criaVeiculo (@RequestBody Veiculo novoVeiculo) {
        Veiculo veiculoSalvo = veiculoRepository.save(novoVeiculo);
        return new ResponseEntity<>(veiculoSalvo, HttpStatus.CREATED);
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
