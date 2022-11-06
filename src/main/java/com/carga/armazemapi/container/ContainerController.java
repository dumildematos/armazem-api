package com.carga.armazemapi.container;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("api/v1/container")
@RequiredArgsConstructor
@CrossOrigin
public class ContainerController {

    private final ContainerService containerService;

    @GetMapping(params = {"page", "size"})
    public ResponseEntity<?> list(@RequestParam int page, @RequestParam int size){
        return ResponseEntity.ok().body(containerService.getAll(page, size));
    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody Container container){
        return ResponseEntity.ok().body(containerService.save(container));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        Optional<Container> old = containerService.findById(id);
        if(old.isEmpty())
            throw new IllegalStateException("Registro não existe!");
        containerService.delete(id);
        return ResponseEntity.ok().body(null);
    }

    @PutMapping
    public ResponseEntity<?> edit(@RequestBody Container container){
        Optional<Container> old = containerService.findById(container.getId());
        if(old.isEmpty())
            throw new IllegalStateException("Registro não existe!");
        return ResponseEntity.ok().body(containerService.save(container));
    }

}
