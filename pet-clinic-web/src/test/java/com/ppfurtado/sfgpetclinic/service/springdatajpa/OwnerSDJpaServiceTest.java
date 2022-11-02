package com.ppfurtado.sfgpetclinic.service.springdatajpa;

import com.ppfurtado.sfgpetclinic.model.Owner;
import com.ppfurtado.sfgpetclinic.repositories.OwnerRepository;
import com.ppfurtado.sfgpetclinic.repositories.PetRepository;
import com.ppfurtado.sfgpetclinic.repositories.PetTypeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import org.mockito.junit.jupiter.MockitoExtension;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class OwnerSDJpaServiceTest {


    @Mock
    OwnerRepository ownerRepository;
    @Mock
    PetRepository petRepository;
    @Mock
    PetTypeRepository petTypeRepository;

    Long id = 1L;
    String lastName = "Furtado";

    @InjectMocks
    OwnerSDJpaService service;

    Owner ownerReturn;

    @BeforeEach
    void setUp() {
        ownerReturn = Owner.builder().id(id).lastName("lastName").build();

    }

    @Test
    void findById() {
        Owner owner = Owner.builder().id(id).lastName("Furtado").build();
        when(ownerRepository.findById(any(Long.class))).thenReturn(java.util.Optional.ofNullable(owner));
        Owner ownerId = service.findById(id);

        assertEquals(1, ownerId.getId());
    }

    @Test
    void save() {
        Owner owner = Owner.builder().id(1L).build();
        when(ownerRepository.save(any(Owner.class))).thenReturn(owner);
        Owner ownerSave = service.save(owner);
        assertNotNull(ownerSave);

    }

    @Test
    void findAll() {
        Set<Owner> owners = new HashSet<>();
        List<Owner> ownersList = new ArrayList<>();
        Owner owner_1 = Owner.builder().id(1L).build();
        Owner owner_2 = Owner.builder().id(2L).build();
        owners.add(owner_1);
        owners.add(owner_2);
        owners.stream().iterator().forEachRemaining(ownersList::add);
        when(ownerRepository.findAll()).thenReturn(ownersList);
        Set<Owner> findAll = service.findAll();

        assertNotNull(findAll);

    }

    @Test
    void delete() {
        service.delete(ownerReturn);
        verify(ownerRepository).delete(any());
    }

    @Test
    void deleteById() {
        service.deleteById(id);
        verify(ownerRepository).deleteById(anyLong());
    }

    @Test
    void findByLastName() {
        when(ownerRepository.findByLastName(any())).thenReturn(ownerReturn);
        Owner ownerfinded = service.findByLastName(lastName);

       verify(ownerRepository).findByLastName(any());

    }
}