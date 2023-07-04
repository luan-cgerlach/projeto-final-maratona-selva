package projetofinal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import projetofinal.entity.MaratonaSelva;
import projetofinal.service.MaratonaSelvaService;

import java.util.List;

@RestController
@RequestMapping("api/maratonaselva")
public class MaratonaSelvaController {

    @Autowired
    private MaratonaSelvaService maratonaSelvaService;

    @PostMapping("salvar")
    public ResponseEntity<MaratonaSelva> salvarMaratonaSelva(@RequestBody MaratonaSelva maratonaSelva){
        return ResponseEntity.status(HttpStatus.CREATED).body(maratonaSelvaService.salvarMaratonaSelva(maratonaSelva));
    }

    @GetMapping("listar")
    public ResponseEntity<List<MaratonaSelva>> listarMaratonaSelva(){
        return ResponseEntity.status(HttpStatus.CREATED).body(maratonaSelvaService.listarMaratonaSelva());
    }

    @GetMapping("{id}")
    public ResponseEntity<MaratonaSelva> buscarPorId(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.CREATED).body(maratonaSelvaService.buscarPorId(id));
    }

    @PutMapping("atualizar")
    public ResponseEntity<MaratonaSelva> atualizar(@RequestBody MaratonaSelva maratonaSelva){
        return ResponseEntity.status(HttpStatus.OK).body(maratonaSelvaService.salvarMaratonaSelva(maratonaSelva));
    }

    @DeleteMapping("deletar/{id}")
    public ResponseEntity<String> deletarPorId(@PathVariable Long id) {
        try {
            maratonaSelvaService.deletarPorId(id);
            return ResponseEntity.status(HttpStatus.OK).body(" Deletado com sucesso!");
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
        }
    }
}
