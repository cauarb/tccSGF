package github.com.cauarb.tccSGF.domain.veiculo.service;

import github.com.cauarb.tccSGF.domain.departamento.entity.Departamento;
import github.com.cauarb.tccSGF.domain.veiculo.entity.Veiculo;
import github.com.cauarb.tccSGF.domain.departamento.repository.DepartamentoRepository;
import github.com.cauarb.tccSGF.domain.veiculo.repository.VeiculoRepository;
import github.com.cauarb.tccSGF.exceptions.VehicleNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VeiculoService {

    @Autowired
    private VeiculoRepository veiculoRepository;

    @Autowired
    private DepartamentoRepository departamentoRepository;

    public Veiculo cadastrarVeiculo(Veiculo novoVeiculo) {
        if (veiculoRepository.existsByPlaca(novoVeiculo.getPlaca())) {
            throw new IllegalArgumentException("Veículo com a mesma placa já existe");
        }

        Long departamentoId = novoVeiculo.getDepartamento().getId();
        Departamento departamento = departamentoRepository.findById(departamentoId)
                .orElseThrow(() -> new IllegalArgumentException("Departamento não encontrado com id: " + departamentoId));

        novoVeiculo.setDepartamento(departamento);

        return veiculoRepository.save(novoVeiculo);
    }

    public Optional<Veiculo> findById(Long id) {
        return veiculoRepository.findById(id);
    }

    public Veiculo atualizarQuilometragem(Long id, Long novaQuilometragem) {
        Veiculo veiculo = veiculoRepository.findById(id)
                .orElseThrow(() -> new VehicleNotFoundException("Veículo não encontrado com id: " + id));

        if (novaQuilometragem < veiculo.getKmAtual()) {
            throw new IllegalArgumentException("A nova quilometragem não pode ser menor que a quilometragem atual");
        }

        veiculo.setKmAtual(novaQuilometragem);
        return veiculoRepository.save(veiculo);
    }

    public Veiculo buscarPorPlaca(String placa) {
        return veiculoRepository.findByPlaca(placa)
                .orElseThrow(() -> new VehicleNotFoundException("Veículo não encontrado com a placa: " + placa));
    }

    public List<Veiculo> listarPorDepartamento(String departamento) {
        return veiculoRepository.findByDepartamentoNome(departamento);
    }
}
