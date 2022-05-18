package com.starlight.clientservice.controller;

import com.starlight.clientservice.model.Client;
import com.starlight.clientservice.service.ClientService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
@RequestMapping("/api/client")
public class ClientController {

    private final ClientService clientService;

    @Autowired
    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping("/data")
    public List<Client> getAllClientsAndTheirOrders() {
        List<Client> users = clientService.getAll();
        log.info("Get all clients and orders.");
        return users;
    }

    @GetMapping("/{id}")
    public Optional<Client> getClientById(@PathVariable Long id) {
        return clientService.findById(id);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteClientAndAllHisOrders(@PathVariable Long id) {
        clientService.delete(id);
        log.info("Client with id " + id + " was deleted.");
        return "Client with id " + id + " was deleted.";
    }

    @PostMapping("/new")
    public Client addNewClient(@RequestBody Client client) {
        clientService.save(client);
        return client;
    }

    @PutMapping("/update")
    public Client updateClientInfo(@RequestBody Client client) {
        clientService.update(client);
        return client;
    }

}
