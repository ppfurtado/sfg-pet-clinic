package com.ppfurtado.sfgpetclinic.repositories;

import com.ppfurtado.sfgpetclinic.model.Pet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PetRepository extends JpaRepository<Pet, Long> {
}
