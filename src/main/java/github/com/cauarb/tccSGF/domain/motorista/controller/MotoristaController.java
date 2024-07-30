package github.com.cauarb.tccSGF.domain.motorista.controller;

import github.com.cauarb.tccSGF.domain.motorista.entity.Motorista;
import github.com.cauarb.tccSGF.domain.motorista.repository.MotoristaRepository;
import github.com.cauarb.tccSGF.domain.motorista.service.MotoristaService;
import github.com.cauarb.tccSGF.exceptions.MotoristaNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/motorista")
public class MotoristaController {


    private final MotoristaService motoristaService;

    @Autowired
    public MotoristaController(MotoristaService motoristaService) {
        this.motoristaService = motoristaService;
    }

    @PostMapping
    public ResponseEntity<Motorista> criaMotorista(@RequestBody Motorista novoMotorista) {
        Motorista motoristaSalvo = motoristaService.cadastroMotorista(novoMotorista);
        return new ResponseEntity<>(motoristaSalvo, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Motorista> buscarMotoristaPorId(@PathVariable Long id) {
        return motoristaService.findById(id)
                .map(motorista -> new ResponseEntity<>(motorista, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/nome/{nome}")
    public ResponseEntity<Motorista> buscarMotoristaPorNome(@PathVariable String nome) {
        try {
            Motorista motorista = motoristaService.buscarPorNome(nome);
            return new ResponseEntity<>(motorista, HttpStatus.OK);
        } catch (MotoristaNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping
    public List<Motorista> listarMotoristas() {
        return motoristaService.listarTodosMotoristas();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarMotorista(@PathVariable Long id) {
        try {
            motoristaService.deletarMotorista(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (MotoristaNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Motorista> editarMotorista(@PathVariable Long id, @RequestBody Motorista motoristaAtualizado) {
        try {
            Motorista motoristaAtualizadoResult = motoristaService.atualizarMotorista(id, motoristaAtualizado);
            return new ResponseEntity<>(motoristaAtualizadoResult, HttpStatus.OK);
        } catch (MotoristaNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
