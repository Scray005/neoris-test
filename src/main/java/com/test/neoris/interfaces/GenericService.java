package com.test.neoris.interfaces;

import java.util.List;

public interface GenericService<T> {

    void save(T t);
    T find(Integer id);
    List<T> findAll();
    void delete (Integer id);

}


