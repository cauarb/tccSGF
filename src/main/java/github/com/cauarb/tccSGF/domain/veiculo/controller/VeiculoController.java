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

import java.util.List;

@RestController
@RequestMapping("/api/veiculo")
public class VeiculoController {

    private final VeiculoRepository veiculoRepository;
    private final VeiculoService veiculoService;

    @Autowired
    public VeiculoController(VeiculoRepository veiculoRepository, VeiculoService veiculoService) {
        this.veiculoRepository = veiculoRepository;
        this.veiculoService = veiculoService;
    }

    @PostMapping
    public ResponseEntity<Veiculo> criaVeiculo(@Validated @RequestBody Veiculo novoVeiculo) {
        try {
            Veiculo veiculoSalvo = veiculoService.cadastrarVeiculo(novoVeiculo);
            return new ResponseEntity<>(veiculoSalvo, HttpStatus.CREATED);
        } catch (IllegalArgumentException e) {
            throw new DataIntegrityViolationException("Dados invalidos para cadastro de veículo");
        }
    }

    @GetMapping("{id}")
    public ResponseEntity<Veiculo> acharPorId(@PathVariable Long id) {
        return veiculoRepository.findById(id)
                .map(veiculo -> new ResponseEntity<>(veiculo, HttpStatus.OK))
                .orElseThrow(() -> new VehicleNotFoundException("Veículo não encontrado com id: " + id));
    }

    @GetMapping
    public ResponseEntity<List<Veiculo>> listarVeiculo() {
        return new ResponseEntity<>(veiculoRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping("/placa/{placa}")
    public ResponseEntity<Veiculo> buscarPorPlaca(@PathVariable String placa) {
        return new ResponseEntity<>(veiculoService.buscarPorPlaca(placa), HttpStatus.OK);
    }

    @PatchMapping("/{id}/quilometragem")
    public ResponseEntity<Veiculo> atualizarQuilometragem(@PathVariable Long id, @RequestParam Long quilometragem) {
        return new ResponseEntity<>(veiculoService.atualizarQuilometragem(id, quilometragem), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        if (!veiculoRepository.existsById(id)) {
            throw new VehicleNotFoundException("Veículo não encontrado com id: " + id);
        }
        veiculoRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Veiculo> editar(@PathVariable Long id, @RequestBody Veiculo veiculoAtualizado) {
        Veiculo veiculoExistente = veiculoRepository.findById(id)
                .orElseThrow(() -> new VehicleNotFoundException("Veículo não encontrado com id: " + id));

        veiculoExistente.setPlaca(veiculoAtualizado.getPlaca());
        veiculoExistente.setModelo(veiculoAtualizado.getModelo());
        veiculoExistente.setMarca(veiculoAtualizado.getMarca());
        veiculoExistente.setAno(veiculoAtualizado.getAno());
        veiculoExistente.setKmInicio(veiculoAtualizado.getKmInicio());
        veiculoExistente.setKmAtual(veiculoAtualizado.getKmAtual());
        veiculoExistente.setDepartamento(veiculoAtualizado.getDepartamento());

        Veiculo veiculoSalvo = veiculoRepository.save(veiculoExistente);
        return new ResponseEntity<>(veiculoSalvo, HttpStatus.OK);
    }
}

