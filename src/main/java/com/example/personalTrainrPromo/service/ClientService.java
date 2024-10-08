package com.example.personalTrainrPromo.service;

import com.example.personalTrainrPromo.domain.Client;

import java.util.List;
import java.util.Optional;

public interface ClientService {
    Client save(Client client);
    List<Client> findAllByActiveTrue();
    Optional<Client> findById(Long id);
    Client update (Client client);
    void deleteById(Long id);
}
