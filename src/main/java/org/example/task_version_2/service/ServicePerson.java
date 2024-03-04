package org.example.task_version_2.service;

import lombok.AllArgsConstructor;
import org.example.task_version_2.entity.Person;
import org.example.task_version_2.repository.PersonRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
@AllArgsConstructor
public class ServicePerson {
    PersonRepository personRepository;

    public List<Person> getAll() {
        return personRepository.findAll();
    }

    public Person savePerson(Person person) {
        List<Person> listPerson = personRepository.findByEmail(person.getEmail());
        if(!listPerson.isEmpty()) {
            throw new IllegalStateException("This is email already exist");
        }
        return personRepository.save(person);
    }

    public void deletePerson(Long id) {
        Optional<Person> listPerson = personRepository.findById(id);
        if(listPerson.isEmpty()) {
            throw new IllegalStateException("There is no employee with this Id");
        }
        personRepository.deleteById(id);
    }

    public void updatePerson(Long id, String name, String email) {
        Person person = null;
        try {
            person = personRepository.findById(id).orElseThrow();
        } catch (IllegalStateException exception) {
            System.out.println("There is no employee with this Id = " + id);
        }

        if (name != null && !name.isEmpty() && name.equals(person.getName())) {
            person.setName(name);
        }
        if (email != null && !email.isEmpty() && email.equals(person.getEmail())) {
            List<Person> listPerson = personRepository.findByEmail(email);
            if(!listPerson.isEmpty()) {
                throw new IllegalStateException("This email is already exist");
            }
            person.setEmail(email);
        }
    }
}
