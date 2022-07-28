package com.ppfurtado.sfgpetclinic.service;

import com.ppfurtado.sfgpetclinic.model.Owner;

import java.util.Set;

public interface OwnerService extends CrudService<Owner, Long> {

    Owner findByLastName(String lastName);

}
