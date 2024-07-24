package github.com.cauarb.tccSGF.domain.veiculo.controller;

import github.com.cauarb.tccSGF.domain.veiculo.entity.Veiculo;
import github.com.cauarb.tccSGF.domain.veiculo.repository.VeiculoRepository;
import github.com.cauarb.tccSGF.domain.veiculo.service.VeiculoService;
import github.com.cauarb.tccSGF.exceptions.DataIntegrityViolationException;
import github.com.cauarb.tccSGF.exceptions.VehicleNotFoundException;
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
            throw new DataIntegrityViolationException("Dados inválidos para cadastro de veículo");
        }
    }

    @GetMapping("{id}")
    public Veiculo acharPorId(@PathVariable Long id) {
        return veiculoRepository.findById(id)
                .orElseThrow(() -> new VehicleNotFoundException("Veículo não encontrado com id: " + id));
    }

    @GetMapping
    public List<Veiculo> listarVeiculo() {
        return veiculoRepository.findAll();
    }

    @GetMapping("/placa/{placa}")
    public Veiculo buscarPorPlaca(@PathVariable String placa) {
        return veiculoService.buscarPorPlaca(placa);
    }

    @PatchMapping("/{id}/quilometragem")
    public Veiculo atualizarQuilometragem(@PathVariable Long id, @RequestParam Long quilometragem) {
        return veiculoService.atualizarQuilometragem(id, quilometragem);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        if (!veiculoRepository.existsById(id)) {
            throw new VehicleNotFoundException("Veículo não encontrado com id: " + id);
        }
        veiculoRepository.deleteById(id);
    }

    @PutMapping("/{id}")
    public Veiculo editar(@PathVariable Long id, @RequestBody Veiculo veiculoAtualizado) {
        Veiculo veiculoExistente = veiculoRepository.findById(id)
                .orElseThrow(() -> new VehicleNotFoundException("Veículo não encontrado com id: " + id));

        veiculoExistente.setPlaca(veiculoAtualizado.getPlaca());
        veiculoExistente.setModelo(veiculoAtualizado.getModelo());
        veiculoExistente.setMarca(veiculoAtualizado.getMarca());
        veiculoExistente.setAno(veiculoAtualizado.getAno());
        veiculoExistente.setKmInicio(veiculoAtualizado.getKmInicio());
        veiculoExistente.setKmAtual(veiculoAtualizado.getKmAtual());
        veiculoExistente.setDepartamento(veiculoAtualizado.getDepartamento());

        return veiculoRepository.save(veiculoExistente);
    }
}

