package github.com.cauarb.tccSGF.domain.departamento.service;

import github.com.cauarb.tccSGF.domain.departamento.entity.Departamento;
import github.com.cauarb.tccSGF.domain.departamento.repository.DepartamentoRepository;
import github.com.cauarb.tccSGF.exceptions.DataIntegrityViolationException;
import github.com.cauarb.tccSGF.exceptions.DepartamentoNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DepartamentoService {

    private final DepartamentoRepository departamentoRepository;
    private static final Logger logger = LoggerFactory.getLogger(DepartamentoService.class);

    @Autowired
    public DepartamentoService(DepartamentoRepository departamentoRepository) {
        this.departamentoRepository = departamentoRepository;
    }

    public Departamento criarDepartamento(Departamento novoDepartamento) {
        logger.info("Cadastrando novo departamento com nome: {}", novoDepartamento.getNome());

        if (departamentoRepository.existsById(novoDepartamento.getId())) {
            throw new DataIntegrityViolationException("Departamento com o mesmo ID já existe");
        }

        // Se precisar de uma lógica adicional para vinculação de departamento, pode ser adicionada aqui

        Departamento departamentoSalvo = departamentoRepository.save(novoDepartamento);

        logger.info("Departamento cadastrado com sucesso: {}", departamentoSalvo);
        return departamentoSalvo;
    }

    public List<Departamento> listarDepartamentos() {
        return departamentoRepository.findAll();
    }

    public Optional<Departamento> buscarPorId(Long id) {
        return departamentoRepository.findById(id);
    }

    public void deletarDepartamento(Long id) {
        if (!departamentoRepository.existsById(id)) {
            throw new DepartamentoNotFoundException(id);
        }
        departamentoRepository.deleteById(id);
    }

    public Departamento atualizarDepartamento(Long id, Departamento departamentoAtualizado) {
        return departamentoRepository.findById(id).map(departamentoExistente -> {
            departamentoExistente.setNome(departamentoAtualizado.getNome());
            // Atualize outros campos, se necessário
            return departamentoRepository.save(departamentoExistente);
        }).orElseThrow(() -> new DepartamentoNotFoundException(id));
    }

    public List<Departamento> buscarPorNome(String nome) {
        return departamentoRepository.findByNomeContaining(nome);
    }
}
