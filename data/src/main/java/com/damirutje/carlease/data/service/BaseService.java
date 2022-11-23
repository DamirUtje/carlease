package com.damirutje.carlease.data.service;

public interface BaseService<E> {

    /**
     * Sets an entity {@link E} to inactive.
     * @param entity to update state
     */
    void setInactive(E entity);
    
}
