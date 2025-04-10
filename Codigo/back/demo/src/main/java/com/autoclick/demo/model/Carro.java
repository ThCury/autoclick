package com.autoclick.demo.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

import org.hibernate.annotations.UuidGenerator;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "carro_tb")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Carro {

    @Id
    @UuidGenerator
    private UUID id;

    private String descricao;

    private String modelo;

    private String marca;

    private String cor;

    private String placa;

    @Positive
    private BigDecimal preco;

    @Positive
    private BigDecimal precoVenda;

    private String chassi;

    private LocalDate dataCompra;

    @Positive
    private BigDecimal precoFipe;

    @Positive
    private Integer ano;

    @PositiveOrZero
    private Integer kmRodados;

    private String renavam;

    private String cpfCnpjUltimoDono;

    private String nomeUltimoDono;

    private String combustivel;

    private String cambio;

    @OneToOne(cascade = CascadeType.ALL)
    private Imagem imagem;
    
}
