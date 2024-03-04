package org.example.task_version_2.controller;

import lombok.AllArgsConstructor;
import org.example.task_version_2.entity.Person;
import org.example.task_version_2.service.ServicePerson;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class ControllerPerson {
    ServicePerson servicePerson;

    @GetMapping
    public List<Person> getAll() {
        return servicePerson.getAll();
    }

    @PostMapping
    public Person savePerson(@RequestBody Person person) {
        return servicePerson.savePerson(person);
    }

    @DeleteMapping(path = "{id}")
    public void deletePerson(@PathVariable Long id) {
        servicePerson.deletePerson(id);
    }

    @PutMapping(path = "{id}")
    public void updatePerson(@PathVariable Long id, String name, String email) {
        servicePerson.updatePerson(id, name, email);
    }
}
