package projetofinal.service;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import projetofinal.entity.Circuito;
import projetofinal.repository.CircuitoRepository;

import java.util.List;

@Service
public class CircuitoService {

        @Autowired
        private CircuitoRepository circuitoRepository;

        public Circuito salvarCircuito(Circuito circuito){

            definirDistanciaDoCircuito(circuito);
            return circuitoRepository.save(circuito);
        }

        public List<Circuito> listarCircuito(){
            return circuitoRepository.findAll();
        }

        public Circuito buscarPorId(Long id){
            return circuitoRepository.findById(id).get();
        }

        @Cascade(CascadeType.ALL)
        public void deletarPorId(Long id){
            if(circuitoRepository.existsById(id)) {
                circuitoRepository.deleteById(id);
            }else {
                throw new RuntimeException("Circuito não encontrado");
            }
        }

        private Circuito definirDistanciaDoCircuito(Circuito circuito){
            switch (circuito.getCategoria()){
                case PEQUENO :
                    circuito.setDistancia("2 km pela selva e riachos.");
                        break;
                case MEDIO:
                    circuito.setDistancia("5 km pela selva, riachos e lama.");
                        break;
                case AVANCADO:
                    circuito.setDistancia("10 km pela selva, riachos, lama e escalada.");
                        break;
            }
            return circuito;
        }
}
