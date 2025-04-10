package com.autoclick.demo.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.autoclick.demo.dto.CarroDto;
import com.autoclick.demo.model.Carro;
import com.autoclick.demo.service.implementation.CarroService;


import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("/api/carro")
@CrossOrigin(origins = "http://localhost:5173")
public class CarroController {
    
    @Autowired
    private CarroService carroService;

    @PostMapping
    public ResponseEntity<String> save(@RequestPart("dto") CarroDto dto, @RequestPart("file") MultipartFile file) {
        carroService.save(dto, file);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/estoque")
    public ResponseEntity<List<Carro>> getCarros() {
        List<Carro> carros = carroService.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(carros);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Void> delete(@RequestBody String placa) {
        carroService.delete(placa);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @PatchMapping("/update/{id}")
    public ResponseEntity<Carro> update(@PathVariable UUID id, @RequestBody CarroDto dto) {
        Carro carro = carroService.update(id, dto);
        return ResponseEntity.status(HttpStatus.OK).body(carro);
    }
}
