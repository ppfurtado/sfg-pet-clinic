package com.ppfurtado.sfgpetclinic.repositories;

import com.ppfurtado.sfgpetclinic.model.PetType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PetTypeRepository extends JpaRepository<PetType, Long> {
}
