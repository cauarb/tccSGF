package github.com.cauarb.tccSGF.domain.motorista.service;

import github.com.cauarb.tccSGF.domain.motorista.entity.Motorista;
import github.com.cauarb.tccSGF.domain.motorista.repository.MotoristaRepository;
import github.com.cauarb.tccSGF.exceptions.DataIntegrityViolationException;
import github.com.cauarb.tccSGF.exceptions.MotoristaNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MotoristaService {

    private final MotoristaRepository motoristaRepository;
    private static final Logger logger = LoggerFactory.getLogger(MotoristaService.class);

    @Autowired
    public MotoristaService(MotoristaRepository motoristaRepository) {
        this.motoristaRepository = motoristaRepository;
    }

    public Motorista cadastroMotorista(Motorista novoMotorista) {
        logger.info("Cadastrando novo Motorista com Nome: {}", novoMotorista.getNome());

        if (motoristaRepository.existsByNome(novoMotorista.getNome())) {
            throw new DataIntegrityViolationException("Motorista com o mesmo nome já existe");
        }

        Motorista motoristaSalvo = motoristaRepository.save(novoMotorista);
        logger.info("Motorista cadastrado com sucesso: {}", motoristaSalvo);
        return motoristaSalvo;
    }

    public Optional<Motorista> findById(Long id) {
        logger.info("Buscando motorista por id: {}", id);
        return motoristaRepository.findById(id);
    }

    public Motorista buscarPorNome(String nome) {
        logger.info("Buscando motorista pelo nome: {}", nome);
        return motoristaRepository.findByNome(nome)
                .orElseThrow(() -> new MotoristaNotFoundException("Motorista não encontrado com o nome: " + nome));
    }

    public Motorista atualizarMotorista(Long id, Motorista motoristaAtualizado) {
        logger.info("Atualizando motorista com id: {}", id);
        Motorista motoristaExistente = motoristaRepository.findById(id)
                .orElseThrow(() -> new MotoristaNotFoundException("Motorista não encontrado com o id: " + id));

        motoristaExistente.setNome(motoristaAtualizado.getNome());
        motoristaExistente.setCpf(motoristaAtualizado.getCpf());
        motoristaExistente.setCnh(motoristaAtualizado.getCnh());
        // Atualize outros campos conforme necessário

        Motorista motoristaSalvo = motoristaRepository.save(motoristaExistente);
        logger.info("Motorista atualizado com sucesso: {}", motoristaSalvo);
        return motoristaSalvo;
    }

    public void deletarMotorista(Long id) {
        logger.info("Deletando motorista com id: {}", id);
        Motorista motoristaExistente = motoristaRepository.findById(id)
                .orElseThrow(() -> new MotoristaNotFoundException("Motorista não encontrado com o id: " + id));

        motoristaRepository.delete(motoristaExistente);
        logger.info("Motorista deletado com sucesso");

    }

    public List<Motorista> listarTodosMotoristas() {
        logger.info("Listando todos os motoristas");
        return motoristaRepository.findAll();
    }
}

