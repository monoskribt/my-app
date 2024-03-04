package org.example.task_version_2.repository;

import org.example.task_version_2.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PersonRepository extends JpaRepository<Person, Long> {
    Optional<Person> findById(Long id);
    List<Person> findByEmail(String email);
    void deleteById(Long id);
}
