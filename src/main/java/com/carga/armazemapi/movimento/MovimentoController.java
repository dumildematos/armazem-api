package com.carga.armazemapi.movimento;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("api/v1/movimento")
@RequiredArgsConstructor
public class MovimentoController {

    private final MovimentoService movimentoService;

    @GetMapping(params = {"page", "size"})
    public ResponseEntity<?> list(@RequestParam int page, @RequestParam int size){
        return ResponseEntity.ok().body(movimentoService.getAll(page, size));
    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody Movimento movimento){
        return ResponseEntity.ok().body(movimentoService.save(movimento));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        Optional<Movimento> old = movimentoService.findById(id);
        if(old.isEmpty())
            throw new IllegalStateException("Registro não existe!");
        movimentoService.delete(id);
        return ResponseEntity.ok().body(null);
    }

    @PutMapping
    public ResponseEntity<?> edit(@RequestBody Movimento movimento){
        Optional<Movimento> old = movimentoService.findById(movimento.getId());
        if(old.isEmpty())
            throw new IllegalStateException("Registro não existe!");
        return ResponseEntity.ok().body(movimentoService.save(movimento));
    }

}
