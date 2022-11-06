package com.carga.armazemapi.container;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Container {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String cliente;
    private String nContainer;
    private int tipo;
    private String status;
    private String categoria;

}
