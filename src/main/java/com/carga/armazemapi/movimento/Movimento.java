package com.carga.armazemapi.movimento;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

import static javax.persistence.GenerationType.AUTO;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Movimento {

    @Id
    @GeneratedValue(strategy = AUTO)
    private Long id;
    private String tipo;
    private LocalDateTime dtInicio;
    private LocalDateTime dtFim;
}
