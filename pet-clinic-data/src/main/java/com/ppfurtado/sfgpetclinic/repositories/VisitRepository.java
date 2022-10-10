package com.ppfurtado.sfgpetclinic.repositories;

import com.ppfurtado.sfgpetclinic.model.Visit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VisitRepository extends JpaRepository<Visit, Long> {
}
