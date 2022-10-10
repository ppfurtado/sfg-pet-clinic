package com.ppfurtado.sfgpetclinic.repositories;

import com.ppfurtado.sfgpetclinic.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {
}
