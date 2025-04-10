package com.autoclick.demo.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.autoclick.demo.model.Carro;

public interface CarroRepository extends JpaRepository<Carro, UUID> {

    boolean existsByPlaca(String placa);

    Optional<Carro> findByPlaca(String placa);

    void deleteByPlaca(String placa);
}
