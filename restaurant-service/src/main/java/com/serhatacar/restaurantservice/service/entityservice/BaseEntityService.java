package com.serhatacar.restaurantservice.service.entityservice;

import com.serhatacar.restaurantservice.common.error.GeneralErrorMessage;
import com.serhatacar.restaurantservice.exception.notfound.ItemNotFoundException;
import lombok.Getter;
import org.springframework.data.solr.repository.SolrCrudRepository;

import java.util.Optional;

/**
 * @author Serhat Acar
 */

@Getter
public abstract class BaseEntityService<E, R extends SolrCrudRepository<E, String>> {

    private final R repository;

    protected BaseEntityService(R repository) {
        this.repository = repository;
    }

    public E save(E entity) {

        entity = repository.save(entity);
        return entity;
    }

    public Iterable<E> findAll() {
        return repository.findAll();
    }

    public Optional<E> findById(String id) {
        return repository.findById(id);
    }

    public E findByIdWithControl(String id) {
        Optional<E> optionalE = repository.findById(id);
        E entity;
        if (optionalE.isPresent()) {
            entity = optionalE.get();
        } else {
            throw new ItemNotFoundException(GeneralErrorMessage.ITEM_NOT_FOUND);
        }
        return entity;
    }

    public void delete(String id) {
        repository.deleteById(id);
    }


    public void delete(E entity) {
        repository.delete(entity);
    }

    public boolean existById(String id) {
        return repository.existsById(id);
    }

}
