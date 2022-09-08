package com.ppfurtado.sfgpetclinic.bootstrap;

import com.ppfurtado.sfgpetclinic.model.Owner;
import com.ppfurtado.sfgpetclinic.model.Pet;
import com.ppfurtado.sfgpetclinic.model.PetType;
import com.ppfurtado.sfgpetclinic.model.Vet;
import com.ppfurtado.sfgpetclinic.service.OwnerService;
import com.ppfurtado.sfgpetclinic.service.PetTypeService;
import com.ppfurtado.sfgpetclinic.service.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoad implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;

    public DataLoad(OwnerService ownerService, VetService vetService, PetTypeService petTypeService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
    }

    @Override
    public void run(String... args) throws Exception {

        PetType dog = new PetType();
        dog.setName("dog");
        PetType savedDogType = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("cat");
        PetType savedCatType = petTypeService.save(cat);

        Owner owner_1 = new Owner();
        owner_1.setFirstName("Pedro Paulo");
        owner_1.setLastName("Furtado");
        owner_1.setAddress("Vila União");
        owner_1.setCity("Belém");
        owner_1.setTelephone("91985544205");

        Pet pedroDog = new Pet();
        pedroDog.setPetType(savedDogType);
        pedroDog.setOwner(owner_1);
        pedroDog.setBirthDate(LocalDate.now());
        pedroDog.setName("Apollo");
        owner_1.getPets().add(pedroDog);

        ownerService.save(owner_1);

        Owner owner_2 = new Owner();
        owner_2.setFirstName("Kelly Cristine");
        owner_2.setLastName("Vilela");
        owner_2.setAddress("Vila União");
        owner_2.setCity("Belém");
        owner_2.setTelephone("91984195550");

        Pet kellyCat = new Pet();
        kellyCat.setOwner(owner_1);
        kellyCat.setPetType(savedCatType);
        kellyCat.setName("Naggs");
        kellyCat.setBirthDate(LocalDate.now());
        owner_2.getPets().add(kellyCat);

        ownerService.save(owner_2);

        System.out.println("Loaded Owners...");

        Vet vet_1 = new Vet();
        vet_1.setFirstName("Lucas");
        vet_1.setLastName("Furtado");
        vetService.save(vet_1);

        Vet vet_2 = new Vet();
        vet_2.setFirstName("Luiza");
        vet_2.setLastName("Furtado");
        vetService.save(vet_2);

        System.out.println("Loaded Vets...");

    }
}
