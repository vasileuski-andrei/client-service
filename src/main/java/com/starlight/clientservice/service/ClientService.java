package com.starlight.clientservice.service;

import com.starlight.clientservice.model.Client;
import com.starlight.clientservice.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class ClientService implements CommonService<Client, Long> {

    private final ClientRepository clientRepository;

    @Autowired
    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    public void save(Client model) {
        model.setCreationDate(LocalDate.now());
        clientRepository.save(model);
    }

    @Override
    public Optional<Client> findById(Long id) {
        return clientRepository.findById(id);
    }

    @Override
    public Client update(Client model) {
        return clientRepository.save(model);
    }

    @Override
    public void delete(Long id) {
        clientRepository.deleteClientById(id);
    }

    @Override
    public List<Client> getAll() {
        return clientRepository.findAll();
    }

}
