package com.carga.armazemapi.container;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ContainerService {

    private final ContainerRepository containerRepository;

    // Lista paginada de container
    public Page<Container> getAll(int page, int size) {
        return containerRepository.findAll(PageRequest.of(page, size));
    }

    // gravar Container
    public Container save(Container container){
        return containerRepository.save(container);
    }

    // detalhar container
    public Optional<Container> findById(Long id){
        return containerRepository.findById(id);
    }

    // eliminar container
    public void delete(Long id){
        containerRepository.deleteById(id);
    }


}
