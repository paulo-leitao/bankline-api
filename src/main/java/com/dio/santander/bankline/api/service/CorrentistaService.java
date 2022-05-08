package com.dio.santander.bankline.api.service;

import com.dio.santander.bankline.api.dto.DeletarCorrentista;
import com.dio.santander.bankline.api.dto.NovoCorrentista;
import com.dio.santander.bankline.api.dto.AtualizarCorrentista;
import com.dio.santander.bankline.api.model.Conta;
import com.dio.santander.bankline.api.model.Correntista;
import com.dio.santander.bankline.api.repository.CorrentistaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class CorrentistaService {
    @Autowired
    private CorrentistaRepository repository;
    public void save(NovoCorrentista novoCorrentista){
        Correntista correntista = new Correntista();
        correntista.setCpf(novoCorrentista.getCpf());
        correntista.setNome(novoCorrentista.getNome());

        Conta conta = new Conta();
        conta.setSaldo(0.0);
        conta.setNumero(new Date().getTime());

        correntista.setConta(conta);
        repository.save(correntista);
    }
    public void update(AtualizarCorrentista atualizarCorrentista){
        Correntista correntista = repository.findById(atualizarCorrentista.getId()).orElse(null);
        if (correntista != null){
            correntista.setId(atualizarCorrentista.getId());
            correntista.setNome(atualizarCorrentista.getNome());
            correntista.setCpf(atualizarCorrentista.getCpf());

            repository.save(correntista);
        }
    }
    public void delete(DeletarCorrentista deletarCorrentista){
        repository.findById(deletarCorrentista.getId()).ifPresent(correntista -> repository.delete(correntista));
    }
}
