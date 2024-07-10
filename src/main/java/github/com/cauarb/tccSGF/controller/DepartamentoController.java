package github.com.cauarb.tccSGF.controller;

import github.com.cauarb.tccSGF.entity.Departamento;
import github.com.cauarb.tccSGF.repository.DepartamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/departamento")
public class DepartamentoController {

    @Autowired
    private DepartamentoRepository departamentoRepository;

    @PostMapping
    public ResponseEntity<Departamento> criaDepartamento (@RequestBody Departamento novoDepartamento) {
        Departamento departamentoSalvo = departamentoRepository.save(novoDepartamento);
        return new ResponseEntity<>(departamentoSalvo, HttpStatus.CREATED);
    }

    @GetMapping
    public List<Departamento> listarDepartamento() {
        return departamentoRepository.findAll();
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        departamentoRepository.deleteById(id);
    }

    @PutMapping("/{id}")
    public void editar(@PathVariable Long id, @RequestBody Departamento departamentoAtualizado) {
        Departamento departamentoExistente = departamentoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Departamento nao encontrado: " + id));

        departamentoExistente.setNome_Departamento(departamentoAtualizado.getNome_Departamento());
        //departamentoExistente.s(departamentoAtualizado.getSubDepartamentos());

        departamentoRepository.save(departamentoExistente);
    }
}
