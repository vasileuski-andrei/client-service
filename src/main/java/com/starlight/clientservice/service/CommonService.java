package com.starlight.clientservice.service;

import java.util.List;
import java.util.Optional;

public interface CommonService<T, V> {

    void save(T model);

    Optional<T> findById(V id);

    T update(T model);

    void delete(V id);

    List<T> getAll();
}
