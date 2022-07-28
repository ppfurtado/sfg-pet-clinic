package com.ppfurtado.sfgpetclinic.service;

import java.util.Set;

public interface CrudService<T, ID> {

    Object findById(ID id);

    T save(T object);

    Set<T> findAll();

    void delete(T object);

    void deleteById(ID id);
}
