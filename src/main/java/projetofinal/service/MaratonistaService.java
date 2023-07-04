package projetofinal.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import projetofinal.entity.Maratonista;
import projetofinal.repository.MaratonistaRepository;

import java.util.List;

@Service
public class MaratonistaService {

    @Autowired
    private MaratonistaRepository maratonistaRepository;

    public Maratonista salvarMaratonista(Maratonista maratonista){
        return maratonistaRepository.save(maratonista);
    }

    public List<Maratonista> listarMaratonistas() {
        return maratonistaRepository.findAll();
    }

    public Maratonista buscarPorId(Long id){
        return maratonistaRepository.findById(id).get();
    }

    public void deletarPorId(Long id){
        if(maratonistaRepository.existsById(id)) {
            maratonistaRepository.deleteById(id);
        }else {
            throw new RuntimeException("Maratonista não encontrada");
        }
    }

    public Maratonista atualizar(Maratonista maratonista){
        return maratonistaRepository.save(maratonista);
    }

}
