package com.ppfurtado.sfgpetclinic.service.springdatajpa;

import com.ppfurtado.sfgpetclinic.model.Speciality;
import com.ppfurtado.sfgpetclinic.repositories.SpecialityRepository;
import com.ppfurtado.sfgpetclinic.service.SpecialtyService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("springdatajpa")
public class SpecialTySDJpaService implements SpecialtyService {

    private final SpecialityRepository repository;

    public SpecialTySDJpaService(SpecialityRepository repository) {
        this.repository = repository;
    }

    @Override
    public Speciality findById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public Speciality save(Speciality object) {
        return repository.save(object);
    }

    @Override
    public Set<Speciality> findAll() {
        Set<Speciality> specialities = new HashSet<>();
        repository.findAll().iterator().forEachRemaining(specialities::add);
        return specialities;
    }

    @Override
    public void delete(Speciality object) {
        repository.delete(object);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
