package projetofinal.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import projetofinal.entity.Inscricao;
import projetofinal.repository.CircuitoRepository;
import projetofinal.repository.InscricaoRepository;
import projetofinal.repository.MaratonistaRepository;

import java.util.List;

@Service
public class InscricaoService {

    @Autowired
    private InscricaoRepository inscricaoRepository;
    @Autowired
    private MaratonistaRepository maratonistaRepository;
    @Autowired
    private CircuitoRepository circuitoRepository;

    public Inscricao salvarInscricao(Inscricao inscricao) throws Exception {
        inscricao.setMaratonista(maratonistaRepository.findById(inscricao.getMaratonista().getId()).get());
        inscricao.setCircuito(circuitoRepository.findById(inscricao.getCircuito().getId()).get());
        return inscricaoRepository.save(verificarCircuito(inscricao));
    }

    public List<Inscricao> listarInscricao(){
        return inscricaoRepository.findAll();
    }

    public Inscricao buscarPorId(Long id){
        return inscricaoRepository.findById(id).get();
    }

    public void deletarPorId(Long id){
        if(inscricaoRepository.existsById(id)) {
            inscricaoRepository.deleteById(id);
        }else {
            throw new RuntimeException("Inscricao não encontrada");
        }
    }

    private Inscricao verificarCircuito(Inscricao inscricao) throws Exception {
            Long maiorDeIdade = verficarIdade(inscricao.getMaratonista().getIdade());
            switch (inscricao.getCircuito().getCategoria()) {
                case PEQUENO:
                    if (maiorDeIdade == 1) {
                        inscricao.setValorInscricao(1500.0);
                    } else {
                        inscricao.setValorInscricao(1300.0);
                    }
                    return inscricao;
                case MEDIO:
                    if (maiorDeIdade == 1) {
                        inscricao.setValorInscricao(2300.0);
                    } else {
                        inscricao.setValorInscricao(2000.0);
                    }
                    return inscricao;
                case AVANCADO:

                    if (maiorDeIdade == 1) {
                        inscricao.setValorInscricao(2800.0);
                        return inscricao;
                    } else {
                        throw new Exception("Menores de 18 anos nao podem participar da categoria AVANÇADO");
                    }
            }
        return null;
    }

    private Long verficarIdade(Long idade ){
        return idade >= 18 ? 1L : 0L; //retorna 1 se maior de 18 e 0 se menor de 18
    }

}
