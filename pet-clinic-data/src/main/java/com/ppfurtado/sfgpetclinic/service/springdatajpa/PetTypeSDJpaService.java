package com.ppfurtado.sfgpetclinic.service.springdatajpa;

import com.ppfurtado.sfgpetclinic.model.PetType;
import com.ppfurtado.sfgpetclinic.repositories.PetTypeRepository;
import com.ppfurtado.sfgpetclinic.service.PetTypeService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("springdatajpa")
public class PetTypeSDJpaService implements PetTypeService {

    private final PetTypeRepository repository;

    public PetTypeSDJpaService(PetTypeRepository repository) {
        this.repository = repository;
    }

    @Override
    public PetType findById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public PetType save(PetType object) {
        return repository.save(object);
    }

    @Override
    public Set<PetType> findAll() {
        Set<PetType> petTypes = new HashSet<>();
        repository.findAll().iterator().forEachRemaining(petTypes::add);
        return petTypes;
    }

    @Override
    public void delete(PetType object) {
        repository.delete(object);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
