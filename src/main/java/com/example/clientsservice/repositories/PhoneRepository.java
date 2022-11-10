package com.example.clientsservice.repositories;

import com.example.clientsservice.models.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PhoneRepository extends JpaRepository<Client, Integer> {

}
