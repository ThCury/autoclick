package com.autoclick.demo.service;

import java.util.List;
import java.util.UUID;

import org.springframework.web.multipart.MultipartFile;

import com.autoclick.demo.dto.CarroDto;
import com.autoclick.demo.model.Carro;

public interface ICarroService {

    void save(CarroDto dto, MultipartFile file);

    List<Carro> findAll();

    void delete(String placa);

    Carro update(UUID id, CarroDto dto);
}
