package com.starlight.clientservice.repository;

import com.starlight.clientservice.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

public interface ClientRepository extends JpaRepository<Client, Long> {

    @Transactional
    void deleteClientById(Long id);

}
