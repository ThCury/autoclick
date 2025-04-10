package com.autoclick.demo.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.autoclick.demo.model.Imagem;

@Repository
public interface ImagemRepository extends JpaRepository<Imagem, UUID> {
}