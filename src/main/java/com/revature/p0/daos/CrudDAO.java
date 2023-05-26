package com.revature.p0.daos;

import java.util.List;

public interface CrudDAO<T> {

    void save(T t);
    void update(String id);
    void delete(String id);
    T findById(String id);
    List<T> findAll();

}
