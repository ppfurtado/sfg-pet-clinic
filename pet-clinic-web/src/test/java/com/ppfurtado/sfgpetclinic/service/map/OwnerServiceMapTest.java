package com.ppfurtado.sfgpetclinic.service.map;

import com.ppfurtado.sfgpetclinic.model.Owner;
import com.ppfurtado.sfgpetclinic.service.PetService;
import com.ppfurtado.sfgpetclinic.service.PetTypeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;


class OwnerServiceMapTest {

    @Mock
    PetTypeService petTypeService;
    @Mock
    PetService petService;

    Long idLong = 1L;
    String lastName = "Vilela";

    OwnerServiceMap ownerServiceMap;

    @BeforeEach
    void setUp() {

        ownerServiceMap = new OwnerServiceMap(new PetTypeMapService() , new PetServiceMap());

        ownerServiceMap.save(Owner.builder().id(1L).lastName(lastName).build());
    }

    @Test
    void findById() {
        Owner owner = ownerServiceMap.findById(idLong);

        assertEquals(1, owner.getId());
    }

    @Test
    void saveExisintId() {
        long id = 2L;
        Owner owner = Owner.builder().id(id).build();
        Owner save = ownerServiceMap.save(owner);

        assertEquals(id, save.getId());

    }

    @Test
    void saveNotId() {

        Owner save = ownerServiceMap.save(Owner.builder().build());

        assertNotNull(save);
        assertNotNull(save.getId());

    }

    @Test
    void findAll() {
        Set<Owner> owners = ownerServiceMap.findAll();

        assertEquals(1, owners.size());

    }

    @Test
    void deleteById() {
        ownerServiceMap.deleteById(1L);

        assertEquals(0, ownerServiceMap.findAll().size());
    }

    @Test
    void delete() {
        ownerServiceMap.delete(ownerServiceMap.findById(idLong));

        assertEquals(0, ownerServiceMap.findAll().size());
    }

    @Test
    void findByLastName() {
        Owner ownerLastName = ownerServiceMap.findByLastName(lastName);

        assertNotNull(ownerLastName);

        assertEquals(idLong, ownerLastName.getId());
    }

    @Test
    void findByLastNameNotFound() {
        Owner ownerLastName = ownerServiceMap.findByLastName("Foo");

        assertNull(ownerLastName);

    }
}