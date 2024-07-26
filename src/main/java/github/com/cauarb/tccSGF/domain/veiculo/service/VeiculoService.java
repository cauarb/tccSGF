package github.com.cauarb.tccSGF.domain.veiculo.service;

import github.com.cauarb.tccSGF.domain.departamento.entity.Departamento;
import github.com.cauarb.tccSGF.domain.veiculo.entity.Veiculo;
import github.com.cauarb.tccSGF.domain.departamento.repository.DepartamentoRepository;
import github.com.cauarb.tccSGF.domain.veiculo.repository.VeiculoRepository;
import github.com.cauarb.tccSGF.exceptions.DataIntegrityViolationException;
import github.com.cauarb.tccSGF.exceptions.VehicleNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VeiculoService {

    private final VeiculoRepository veiculoRepository;
    private final DepartamentoRepository departamentoRepository;
    private static final Logger logger = LoggerFactory.getLogger(VeiculoService.class);

    @Autowired
    public VeiculoService(VeiculoRepository veiculoRepository, DepartamentoRepository departamentoRepository) {
        this.veiculoRepository = veiculoRepository;
        this.departamentoRepository = departamentoRepository;
    }

    public Veiculo cadastrarVeiculo(Veiculo novoVeiculo) {
        logger.info("Cadastrando novo veículo com placa: {}", novoVeiculo.getPlaca());

        if (veiculoRepository.existsByPlaca(novoVeiculo.getPlaca())) {
            throw new DataIntegrityViolationException("Veículo com a mesma placa já existe");
        }

        Long departamentoId = novoVeiculo.getDepartamento().getId();
        Departamento departamento = departamentoRepository.findById(departamentoId)
                .orElseThrow(() -> new DataIntegrityViolationException("Departamento não encontrado com id: " + departamentoId));

        novoVeiculo.setDepartamento(departamento);
        Veiculo veiculoSalvo = veiculoRepository.save(novoVeiculo);

        logger.info("Veículo cadastrado com sucesso: {}", veiculoSalvo);
        return veiculoSalvo;
    }

    public Optional<Veiculo> findById(Long id) {
        logger.info("Buscando veículo por id: {}", id);
        return veiculoRepository.findById(id);
    }

    public Veiculo atualizarQuilometragem(Long id, Long novaQuilometragem) {
        logger.info("Atualizando quilometragem do veículo com id: {}", id);

        Veiculo veiculo = veiculoRepository.findById(id)
                .orElseThrow(() -> new VehicleNotFoundException("Veículo não encontrado com id: " + id));

        if (novaQuilometragem < veiculo.getKmAtual()) {
            throw new DataIntegrityViolationException("A nova quilometragem não pode ser menor que a quilometragem atual");
        }

        veiculo.setKmAtual(novaQuilometragem);
        Veiculo veiculoAtualizado = veiculoRepository.save(veiculo);

        logger.info("Quilometragem atualizada com sucesso para veículo com id: {}", id);
        return veiculoAtualizado;
    }

    public Veiculo buscarPorPlaca(String placa) {
        logger.info("Buscando veículo por placa: {}", placa);
        return veiculoRepository.findByPlaca(placa)
                .orElseThrow(() -> new VehicleNotFoundException("Veículo não encontrado com a placa: " + placa));
    }

    public List<Veiculo> listarPorDepartamento(String departamento) {
        logger.info("Listando veículos por departamento: {}", departamento);
        return veiculoRepository.findByDepartamentoNome(departamento);
    }
}
