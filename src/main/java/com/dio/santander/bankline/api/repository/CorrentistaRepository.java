package com.dio.santander.bankline.api.repository;

import com.dio.santander.bankline.api.model.Correntista;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CorrentistaRepository extends JpaRepository<Correntista, Integer> {
    //List<Correntista> findByIdCorrentista(Integer id);
}
