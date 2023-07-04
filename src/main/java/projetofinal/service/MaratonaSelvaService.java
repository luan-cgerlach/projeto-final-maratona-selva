package projetofinal.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import projetofinal.entity.MaratonaSelva;
import projetofinal.repository.MaratonaSelvaRepository;

import java.util.List;

@Service
public class MaratonaSelvaService {


    @Autowired
    private MaratonaSelvaRepository maratonaSelvaRepository;

    public MaratonaSelva salvarMaratonaSelva(MaratonaSelva maratonaSelva){
        return maratonaSelvaRepository.save(maratonaSelva);
    }

    public List<MaratonaSelva> listarMaratonaSelva(){
        return maratonaSelvaRepository.findAll();
    }

    public MaratonaSelva buscarPorId(Long id){
        return maratonaSelvaRepository.findById(id).get();
    }

    public void deletarPorId(Long id){
        if(maratonaSelvaRepository.existsById(id)) {
            maratonaSelvaRepository.deleteById(id);
        }else {
            throw new RuntimeException("MaratonaSelva não encontrada");
        }
    }
}
