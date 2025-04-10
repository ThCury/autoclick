package com.autoclick.demo.service.implementation;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.autoclick.demo.config.exceptions.CarroNaoEncontradoException;
import com.autoclick.demo.config.exceptions.PlacaCadastradaException;
import com.autoclick.demo.dto.CarroDto;

import com.autoclick.demo.model.Carro;
import com.autoclick.demo.model.Imagem;
import com.autoclick.demo.repository.CarroRepository;
import com.autoclick.demo.repository.ImagemRepository;
import com.autoclick.demo.service.ICarroService;
import com.autoclick.demo.utils.UploadUtil;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class CarroService implements ICarroService {

    @Autowired
    private CarroRepository carroRepository;

    @Autowired
    private ImagemRepository imagemRepository;
    
    @Override
    @Transactional
    public void save(CarroDto dto, MultipartFile file) {
        if (carroRepository.existsByPlaca(dto.placa())) {
            throw new PlacaCadastradaException();
        }

        if(!UploadUtil.fazerUploadImagem(file)){

        
        }

        Imagem imagem = Imagem.builder().name(file.getOriginalFilename())
                    .type(file.getContentType())
                    .build();

            imagemRepository.save(imagem);

        carroRepository.save(Carro.builder()                               
            .preco(dto.preco())
            .precoFipe(dto.precoFipe())
            .ano(dto.ano())
            .kmRodados(dto.kmRodados())
            .renavam(dto.renavam())
            .cpfCnpjUltimoDono(dto.cpfCnpjUltimoDono())
            .dataCompra(dto.dataCompra())
            .modelo(dto.modelo())
            .marca(dto.marca())
            .cor(dto.cor())
            .chassi(dto.chassi())
            .placa(dto.placa())
            .nomeUltimoDono(dto.nomeUltimoDono())
            .precoVenda(dto.precoVenda())
            .cambio(dto.cambio())
            .combustivel(dto.combustivel())
            .descricao(dto.descricao())
            .imagem(imagem)
            .build()
            );
    }

    @Override
    public List<Carro> findAll() {
        try {
            List<Carro> carros = carroRepository.findAll();
            return carros;

        } catch (Exception e) {
            System.err.println("Erro ao listar carros: " + e);
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    @Transactional
    public void delete(String placa) {
        try {
            carroRepository.deleteByPlaca(placa);

        } catch (EntityNotFoundException e) {
            System.err.println("Erro ao encontrar o carro: " + e);
            throw new EntityNotFoundException(e.getMessage());
        }

    }

    @Override
    public Carro update(UUID id, CarroDto dto) {
        return carroRepository.findById(id)
                .map(carro -> {
                    BeanUtils.copyProperties(dto, carro, getCamposNulos(dto));
                    return carroRepository.save(carro);
                }).orElseThrow(() -> new CarroNaoEncontradoException());
    }

    private String[] getCamposNulos(CarroDto dto) {
        return Arrays.stream(CarroDto.class.getDeclaredFields())
                .filter(field -> {
                    field.setAccessible(true);
                    try {
                        return field.get(dto) == null;
                    } catch (IllegalAccessException e) {
                        return false;
                    }
                })
                .map(Field::getName)
                .toArray(String[]::new);
    }
}
