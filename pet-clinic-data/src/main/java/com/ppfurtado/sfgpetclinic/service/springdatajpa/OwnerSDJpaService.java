package com.ppfurtado.sfgpetclinic.service.springdatajpa;

import com.ppfurtado.sfgpetclinic.model.Owner;
import com.ppfurtado.sfgpetclinic.repositories.OwnerRepository;
import com.ppfurtado.sfgpetclinic.service.OwnerService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("springdatajpa")
public class OwnerSDJpaService implements OwnerService {

    private final OwnerRepository repository;

    public OwnerSDJpaService(OwnerRepository repository) {
        this.repository = repository;
    }

    @Override
    public Owner findById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public Owner save(Owner object) {
        return repository.save(object);
    }

    @Override
    public Set<Owner> findAll() {
        Set<Owner> owners = new HashSet<>();
        repository.findAll().iterator().forEachRemaining(owners::add);
        return owners;
    }

    @Override
    public void delete(Owner object) {
        repository.delete(object);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Owner findByLastName(String lastName) {
        return repository.findByLastName(lastName);
    }
}
