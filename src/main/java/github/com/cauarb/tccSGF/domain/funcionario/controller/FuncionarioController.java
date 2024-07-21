package github.com.cauarb.tccSGF.domain.funcionario.controller;

import github.com.cauarb.tccSGF.domain.funcionario.entity.Funcionario;
import github.com.cauarb.tccSGF.domain.funcionario.repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/funcionario")
public class FuncionarioController {

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    @PostMapping
    public ResponseEntity<Funcionario> criaFuncionario (@RequestBody Funcionario novoFuncionario) {
        Funcionario funcionarioSalvo = funcionarioRepository.save(novoFuncionario);
        return new ResponseEntity<>(funcionarioSalvo, HttpStatus.CREATED);
    }

    @GetMapping
    public List<Funcionario> listarFuncionario() {
        return funcionarioRepository.findAll();
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        funcionarioRepository.deleteById(id);
    }

    @PutMapping("/{id}")
    public void editar(@PathVariable Long id, @RequestBody Funcionario funcionarioAtualizado) {
        Funcionario funcionarioExistente = funcionarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Funcionario nao encontrado: " + id));

        funcionarioExistente.setNome(funcionarioAtualizado.getNome());
        funcionarioExistente.setCargo(funcionarioAtualizado.getCargo());

        funcionarioRepository.save(funcionarioExistente);
    }

}
