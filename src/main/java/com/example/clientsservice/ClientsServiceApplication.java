package com.example.clientsservice;

import com.example.clientsservice.models.Client;
import com.example.clientsservice.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

import java.util.List;

@SpringBootApplication
public class ClientsServiceApplication {
    public ClientsServiceApplication(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(ClientsServiceApplication.class, args);
    }

    private final ClientRepository clientRepository;

    //@EventListener(ApplicationReadyEvent.class)
    public void applicationReady() {
        Client a = new Client(1, "a", "a", "a", Client.Gender.MALE, "a@test.com",
                null, null, null);
        Client b = new Client(2, "b", "b", "b", Client.Gender.MALE, "b@test.com",
                null, null, null);
        clientRepository.saveAll(List.of(a,b));
    }
}
