package com.ppfurtado.sfgpetclinic.service.springdatajpa;

import com.ppfurtado.sfgpetclinic.model.Vet;
import com.ppfurtado.sfgpetclinic.repositories.VetRespitory;
import com.ppfurtado.sfgpetclinic.service.VetService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("springdatajpa")
public class VetSDJpaService implements VetService {

    private final VetRespitory repository;

    public VetSDJpaService(VetRespitory respitory) {
        this.repository = respitory;
    }

    @Override
    public Vet findById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public Vet save(Vet object) {
        return repository.save(object);
    }

    @Override
    public Set<Vet> findAll() {
        Set<Vet> vets = new HashSet<>();
        repository.findAll().iterator().forEachRemaining(vets::add);
        return vets;
    }

    @Override
    public void delete(Vet object) {
        repository.delete(object);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
