package github.com.cauarb.tccSGF.controller;

import github.com.cauarb.tccSGF.entity.Motorista;
import github.com.cauarb.tccSGF.repository.MotoristaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/motorista")
public class MotoristaController {

    @Autowired
    private MotoristaRepository motoristaRepository;

    @PostMapping
    public ResponseEntity<Motorista> criaMotorista (@RequestBody Motorista novoMotorista) {
        Motorista motoristaSalvo = motoristaRepository.save(novoMotorista);
        return new ResponseEntity<>(motoristaSalvo, HttpStatus.CREATED);
    }

    @GetMapping
    public List<Motorista> listarMotorista() {
        return motoristaRepository.findAll();
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        motoristaRepository.deleteById(id);
    }

    @PutMapping("/{id}")
    public void editar(@PathVariable Long id, @RequestBody Motorista motoristaAtualizado) {
        Motorista motoristaExistente = motoristaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Motorista nao encontrado: " + id));

        motoristaExistente.setNome(motoristaAtualizado.getNome());
        motoristaExistente.setCnh(motoristaAtualizado.getCnh());

        motoristaRepository.save(motoristaExistente);
    }
}
