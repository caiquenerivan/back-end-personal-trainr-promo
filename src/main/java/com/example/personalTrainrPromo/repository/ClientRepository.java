package com.example.personalTrainrPromo.repository;

import com.example.personalTrainrPromo.domain.Client;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClientRepository extends JpaRepository<Client, Long> {
    List<Client> findAllByActiveTrue();
}
