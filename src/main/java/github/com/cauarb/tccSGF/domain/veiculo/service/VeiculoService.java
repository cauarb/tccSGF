package github.com.cauarb.tccSGF.domain.veiculo.service;

import github.com.cauarb.tccSGF.domain.veiculo.entity.Veiculo;
import github.com.cauarb.tccSGF.domain.departamento.repository.DepartamentoRepository;
import github.com.cauarb.tccSGF.domain.veiculo.repository.VeiculoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VeiculoService {

    @Autowired
    private VeiculoRepository veiculoRepository;

    private DepartamentoRepository departamentoRepository;

    @Transactional
    public Veiculo cadastrarVeiculo(Veiculo veiculo) {
        if (veiculo.getDepartamento() == null ||
                !departamentoRepository.existsById(veiculo.getDepartamento().getId_Departamento())) {
            throw new IllegalArgumentException("Departamento invalido ou nao fornecido");
        }
        return veiculoRepository.save(veiculo);
    }
}
