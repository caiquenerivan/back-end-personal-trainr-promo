package com.example.personalTrainrPromo.controller;

import com.example.personalTrainrPromo.domain.Client;
import com.example.personalTrainrPromo.dto.ClientRequestDTO;
import com.example.personalTrainrPromo.service.ClientService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/clients")
public class ClientContoller {
    @Autowired
    private ClientService clientService;

    @GetMapping
    public ResponseEntity getAllPosts(){
        var allUsers = clientService.findAllByActiveTrue();
        return ResponseEntity.ok(allUsers);
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping("/{id}")
    public ResponseEntity getPostById(@PathVariable Long id){
        Optional<Client> optionalClient = clientService.findById(id);
        if (optionalClient.isPresent()){
            Client client = optionalClient.get();
            return ResponseEntity.ok(client);
        } else {
            throw new EntityNotFoundException();
        }
    }

    @PostMapping
    public ResponseEntity registerClient(@RequestBody @Valid ClientRequestDTO data){
        Client newClient = new Client(data);
        clientService.save(newClient);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity updateClient(@PathVariable Long id, @RequestBody ClientRequestDTO data){
        Optional<Client> optionalClient = clientService.findById(id);
        if (optionalClient.isPresent()){
            Client client = optionalClient.get();

            client.setName(data.name());
            client.setEmail(data.email());

            return ResponseEntity.ok(client);
        } else {
            throw new EntityNotFoundException();
        }
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity deleteClient(@PathVariable Long id){
        Optional<Client> optionalClient = clientService.findById(id);
        if (optionalClient.isPresent()){
            Client client = optionalClient.get();

            client.setActive(false);

            return ResponseEntity.noContent().build();
        } else
            throw new EntityNotFoundException();
    }
}
