package com.ppfurtado.sfgpetclinic.bootstrap;

import com.ppfurtado.sfgpetclinic.model.*;
import com.ppfurtado.sfgpetclinic.service.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoad implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialtyService specialtiesService;
    private final VisitService visitService;

    public DataLoad(OwnerService ownerService, VetService vetService, PetTypeService petTypeService, SpecialtyService specialtiesService, VisitService service) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialtiesService = specialtiesService;
        this.visitService = service;
    }

    @Override
    public void run(String... args){

        int count = petTypeService.findAll().size();
        if (count == 0){
            loadData();
        }
    }

    private void loadData() {
        PetType dog = new PetType();
        dog.setName("dog");
        PetType savedDogType = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("cat");
        PetType savedCatType = petTypeService.save(cat);

        Speciality speciality_1 = new Speciality();
        speciality_1.setDescription("veterinário dermatologista");
        specialtiesService.save(speciality_1);

        Speciality speciality_2 = new Speciality();
        speciality_2.setDescription("veterinário Cirurgista de Mão");
        specialtiesService.save(speciality_2);

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

        Visit catVisit = new Visit();
        catVisit.setPet(kellyCat);
        catVisit.setDate(LocalDate.now());
        catVisit.setDescription("Visit cat Kelly");
        visitService.save(catVisit);

        System.out.println("Loaded Owners...");

        Vet vet_1 = new Vet();
        vet_1.setFirstName("Lucas");
        vet_1.setLastName("Furtado");
        vet_1.getSpecialities().add(speciality_2);
        vetService.save(vet_1);

        Vet vet_2 = new Vet();
        vet_2.setFirstName("Luiza");
        vet_2.setLastName("Furtado");
        vetService.save(vet_2);
        vet_2.getSpecialities().add(speciality_2);

        System.out.println("Loaded Vets...");
    }
}
