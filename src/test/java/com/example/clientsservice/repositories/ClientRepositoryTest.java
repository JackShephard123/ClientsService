package com.example.clientsservice.repositories;

import com.example.clientsservice.models.Client;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ClientRepositoryTest {
    @Autowired
    ClientRepository clientRepository;

    static Client a = new Client(0, "a", "a", "a", Client.Gender.FEMALE,
            "a@test.com", null, null, null);

    static Client b = new Client(0, "b", "b", "b", Client.Gender.MALE,
            "b@test.com", null, null, null);

    @Test
    @Order(1)
    public void saveAll() {
        Client a_saved = clientRepository.save(a);
        Client b_saved = clientRepository.save(b);
        a.setId(a_saved.getId());
        b.setId(b_saved.getId());
        assertEquals(a, a_saved);
        assertEquals(b, b_saved);
    }

    @Test
    @Order(2)
    void findAllByCount() {
        assertEquals(2, clientRepository.findAll().size());
    }

    @Test
    @Order(3)
    void findAllByCollection() {
        List<Client> original = List.of(a,b);
        List<Client> saved =clientRepository.findAll();
        assertIterableEquals(original,saved);
    }

    @Test
    @Order(4)
    void findAllBySurnameNamePatronymic() {
        List<Client> actual =
        clientRepository.findAllBySurnameAndNameAndPatronymic(
                a.getSurname(),a.getName(),a.getPatronymic()
        );
        System.out.println(actual);
        assertEquals(a,actual.get(0));
    }

    @Test
    @Order(5)
    void deleteAll() {
        clientRepository.deleteAll();
        assertEquals(0, clientRepository.findAll().size());
    }
}
