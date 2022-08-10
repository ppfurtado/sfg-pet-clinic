package com.ppfurtado.sfgpetclinic.bootstrap;

import com.ppfurtado.sfgpetclinic.model.Owner;
import com.ppfurtado.sfgpetclinic.model.Vet;
import com.ppfurtado.sfgpetclinic.service.OwnerService;
import com.ppfurtado.sfgpetclinic.service.VetService;
import com.ppfurtado.sfgpetclinic.service.map.OwnerServiceMap;
import com.ppfurtado.sfgpetclinic.service.map.VetServiceMap;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoad implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;

    public DataLoad(OwnerService ownerService, VetService vetService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
    }

    @Override
    public void run(String... args) throws Exception {

        Owner owner_1 = new Owner();
        owner_1.setFirstName("Pedro Paulo");
        owner_1.setLastName("Furtado");
        ownerService.save(owner_1);

        Owner owner_2 = new Owner();
        owner_2.setFirstName("Kelly Cristine");
        owner_2.setLastName("Vilela");
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
