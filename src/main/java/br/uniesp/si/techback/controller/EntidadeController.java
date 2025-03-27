package br.uniesp.si.techback.controller;

import br.uniesp.si.techback.model.EntidadeBase;
import br.uniesp.si.techback.service.EntidadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/entidades")
public class EntidadeController {

    @Autowired
    EntidadeService service;

    @GetMapping
    public List<EntidadeBase> listarTodo() {
        return service.listarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<EntidadeBase> buscarPorId(@PathVariable Integer id) {
        return service.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public EntidadeBase criar(@RequestBody EntidadeBase entidade) {
        return service.salvar(entidade);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EntidadeBase> atualizar(@PathVariable Integer id, @RequestBody EntidadeBase entidade) {
        try {
            EntidadeBase atualizada = service.atualizar(id, entidade);
            return ResponseEntity.ok(atualizada);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Integer id) {
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }

}
