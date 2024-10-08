package com.example.personalTrainrPromo.service;

import com.example.personalTrainrPromo.domain.Client;
import com.example.personalTrainrPromo.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientServiceImpl implements ClientService {
    @Autowired
    private ClientRepository clientRepository;
    @Override
    public Client save(Client post){
        return clientRepository.save(post);
    }
    @Override
    public List<Client> findAllByActiveTrue() {
        return clientRepository.findAllByActiveTrue();
    }
    @Override
    public Optional<Client> findById(Long id) {
        return clientRepository.findById(id);
    }

    @Override
    public Client update(Client post) {
        return clientRepository.save(post);
    }

    @Override
    public void deleteById(Long id) {
        clientRepository.deleteById(id);
    }
}
