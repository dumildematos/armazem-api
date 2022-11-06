package com.carga.armazemapi.movimento;

import com.carga.armazemapi.container.Container;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MovimentoService {

    private final MovimentoRepository movimentoRepository;

    public Page<Movimento> getAll(int page, int size) {
        return movimentoRepository.findAll(PageRequest.of(page, size));
    }

    // gravar movimento
    public Movimento save(Movimento movimento){
        return movimentoRepository.save(movimento);
    }

    // detalhar movimento
    public Optional<Movimento> findById(Long id){
        return movimentoRepository.findById(id);
    }

    // eliminar movimento
    public void delete(Long id){
        movimentoRepository.deleteById(id);
    }

}
