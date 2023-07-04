    package projetofinal.controller;
    
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.http.HttpStatus;
    import org.springframework.http.ResponseEntity;
    import org.springframework.web.bind.annotation.*;
    import projetofinal.entity.Maratonista;
    import projetofinal.service.MaratonistaService;

    import java.util.List;

    @RestController
    @RequestMapping("api/maratonista/")
    public class MaratonistaController {
    
        @Autowired
        private MaratonistaService maratonistaService;
    
        @PostMapping("salvar")
        public ResponseEntity<Maratonista> salvarMaratonista(@RequestBody Maratonista maratonista){
            return ResponseEntity.status(HttpStatus.CREATED).body(maratonistaService.salvarMaratonista(maratonista));
        }

        @GetMapping("listar")
        public ResponseEntity<List<Maratonista>> listarMaratonistas(){
            return ResponseEntity.status(HttpStatus.CREATED).body(maratonistaService.listarMaratonistas());
        }

        @GetMapping("{id}")
        public ResponseEntity<Maratonista> buscarPorId(@PathVariable Long id){
            return ResponseEntity.status(HttpStatus.CREATED).body(maratonistaService.buscarPorId(id));
        }

        @PutMapping("atualizar")
        public ResponseEntity<Maratonista> atualizar(@RequestBody Maratonista maratonista){
            return ResponseEntity.status(HttpStatus.OK).body(maratonistaService.salvarMaratonista(maratonista));
        }

        @DeleteMapping("deletar/{id}")
        public ResponseEntity<String> deletarPorId(@PathVariable Long id) {
            try {
                maratonistaService.deletarPorId(id);
                return ResponseEntity.status(HttpStatus.OK).body(" Deletado com sucesso!");
            } catch (Exception ex) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
            }
        }
    }
