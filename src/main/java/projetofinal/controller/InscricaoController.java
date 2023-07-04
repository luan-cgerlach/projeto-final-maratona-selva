package projetofinal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import projetofinal.entity.Inscricao;
import projetofinal.service.InscricaoService;

import java.util.List;

@RestController
@RequestMapping("api/inscricao")
public class InscricaoController {

    @Autowired
    private InscricaoService inscricaoService;

    @PostMapping("salvar")
    public ResponseEntity<Inscricao> salvarInscricao(@RequestBody Inscricao inscricao) throws Exception {
            return ResponseEntity.status(HttpStatus.CREATED).body(inscricaoService.salvarInscricao(inscricao));
    }

    @GetMapping("listar")
    public ResponseEntity<List<Inscricao>> listarInscricao(){
        return ResponseEntity.status(HttpStatus.CREATED).body(inscricaoService.listarInscricao());
    }

    @GetMapping("{id}")
    public ResponseEntity<Inscricao> buscarPorId(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.CREATED).body(inscricaoService.buscarPorId(id));
    }

    @PutMapping("atualizar")
    public ResponseEntity<Inscricao> atualizar(@RequestBody Inscricao inscricao) throws Exception {
        return ResponseEntity.status(HttpStatus.OK).body(inscricaoService.salvarInscricao(inscricao));
    }

    @DeleteMapping("deletar/{id}")
    public ResponseEntity<String> deletarPorId(@PathVariable Long id) {
        try {
            inscricaoService.deletarPorId(id);
            return ResponseEntity.status(HttpStatus.OK).body(" Deletado com sucesso!");
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
        }
    }
}
