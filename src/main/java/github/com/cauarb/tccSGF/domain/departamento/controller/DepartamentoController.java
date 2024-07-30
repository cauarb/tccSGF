package github.com.cauarb.tccSGF.domain.departamento.controller;

import github.com.cauarb.tccSGF.domain.departamento.entity.Departamento;
import github.com.cauarb.tccSGF.domain.departamento.repository.DepartamentoRepository;
import github.com.cauarb.tccSGF.domain.departamento.service.DepartamentoService;
import github.com.cauarb.tccSGF.exceptions.DataIntegrityViolationException;
import github.com.cauarb.tccSGF.exceptions.DepartamentoNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/departamento")
public class DepartamentoController {

    @Autowired
    private DepartamentoRepository departamentoRepository;

    @Autowired
    private DepartamentoService departamentoService;

    @PostMapping
    public ResponseEntity<Departamento> criaDepartamento (@Validated @RequestBody Departamento novoDepartamento) {
        try {
            Departamento departamentoSalvo = departamentoService.criarDepartamento(novoDepartamento);
            return new ResponseEntity<>(departamentoSalvo, HttpStatus.CREATED);
        } catch (DataIntegrityViolationException e) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
    }

    @GetMapping
    public List<Departamento> listarDepartamento() {
        return departamentoService.listarDepartamentos();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        try {
            departamentoService.deletarDepartamento(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (DepartamentoNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Departamento> editar(@PathVariable Long id, @Validated @RequestBody Departamento departamentoAtualizado) {
        try {
            Departamento departamentoSalvo = departamentoService.atualizarDepartamento(id, departamentoAtualizado);
            return new ResponseEntity<>(departamentoSalvo, HttpStatus.OK);
        } catch (DepartamentoNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/search")
    public List<Departamento> buscarPorNome(@RequestParam String nome) {
        return departamentoService.buscarPorNome(nome);
    }
}
