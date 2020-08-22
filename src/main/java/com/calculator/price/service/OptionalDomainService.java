package com.calculator.price.service;

import com.calculator.price.model.AbstractBaseEntity;
import com.calculator.price.model.LoanInfo;
import com.calculator.price.model.LoanInfoRequest;

import java.util.List;
import java.util.Optional;

public interface OptionalDomainService<D extends AbstractBaseEntity> {
    /**
     * Get specific optional entity for given id
     * @param id of entity
     * @return Optional of entity
     */
    Optional<D> get(String id);

    /**
     * Gets all entities
     * @return list of all entities
     */
    List<D> getAll();

    /**
     * Save a given entity
     * @param entity to save
     * @return
     */
    void save(D entity);

    /**
     * Delete given entity
     * @param id of entity to delete
     */
    void delete(String id);
}
