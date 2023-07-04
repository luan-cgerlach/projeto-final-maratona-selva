package projetofinal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import projetofinal.entity.Circuito;
import projetofinal.service.CircuitoService;
import java.util.List;

@RestController
@RequestMapping("api/circuito/")
public class CircuitoController {

    @Autowired
    private CircuitoService circuitoService;

    @PostMapping("salvar")
    public ResponseEntity<Circuito> salvarCircuito(@RequestBody Circuito circuito){
        return ResponseEntity.status(HttpStatus.CREATED).body(circuitoService.salvarCircuito(circuito));
    }

    @GetMapping("listar")
    public ResponseEntity<List<Circuito>> listarCircuito(){
        return ResponseEntity.status(HttpStatus.CREATED).body(circuitoService.listarCircuito());
    }
    @GetMapping("{id}")
    public ResponseEntity<Circuito> buscarPorId(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.CREATED).body(circuitoService.buscarPorId(id));
    }

    @PutMapping("atualizar")
    public ResponseEntity<Circuito> atualizar(@RequestBody Circuito circuito){
        return ResponseEntity.status(HttpStatus.OK).body(circuitoService.salvarCircuito(circuito));
    }

    @DeleteMapping("deletar/{id}")
    public ResponseEntity<String> deletarPorId(@PathVariable Long id) {
        try {
            circuitoService.deletarPorId(id);
            return ResponseEntity.status(HttpStatus.OK).body(" Deletado com sucesso!");
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
        }
    }
}
