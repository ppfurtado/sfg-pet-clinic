package com.ppfurtado.sfgpetclinic.service.map;

import com.ppfurtado.sfgpetclinic.model.Speciality;
import com.ppfurtado.sfgpetclinic.model.Vet;
import com.ppfurtado.sfgpetclinic.service.SpecialtyService;
import com.ppfurtado.sfgpetclinic.service.VetService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class VetServiceMap extends AbstractMapService<Vet, Long> implements VetService {

    private final SpecialtyService specialtiesService;

    public VetServiceMap(SpecialtyService specialtiesService) {
        this.specialtiesService = specialtiesService;
    }

    @Override
    public Vet findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Vet save(Vet object) {

        if (object.getSpecialities().size() > 0){
            object.getSpecialities().forEach(speciality -> {
                if (speciality.getId() == null){
                    Speciality saveSpeciality = specialtiesService.save(speciality);
                    speciality.setId(saveSpeciality.getId());

                }
            });
        }

        return super.save(object);
    }

    @Override
    public Set<Vet> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Vet object) {
        super.delete(object);
    }
}
