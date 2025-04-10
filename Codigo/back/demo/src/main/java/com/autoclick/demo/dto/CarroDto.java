package com.autoclick.demo.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.autoclick.demo.model.Imagem;

public record CarroDto(
                BigDecimal preco,
                BigDecimal precoFipe,
                Integer ano,
                Integer kmRodados,
                String renavam,
                String cpfCnpjUltimoDono,
                LocalDate dataCompra,
                String modelo,
                String marca,
                String cor,
                String chassi,
                String placa,
                String nomeUltimoDono,
                BigDecimal precoVenda,
                String cambio,
                String combustivel,
                String descricao) {

}
