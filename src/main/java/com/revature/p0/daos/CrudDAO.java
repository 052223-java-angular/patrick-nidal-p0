package com.revature.p0.daos;

import java.util.List;

public interface CrudDAO<T> {
    //might not need this i guess if we dont use enough of the methods from it

    void save(T t);
    void update(String id);
    void delete(String id);
    T findById(String id);
    List<T> findAll();

}
