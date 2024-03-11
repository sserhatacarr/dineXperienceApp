package com.serhatacar.restaurantservice.service.entityservice;

import com.serhatacar.restaurantservice.common.base.BaseAdditionalFields;
import com.serhatacar.restaurantservice.common.base.BaseEntity;
import com.serhatacar.restaurantservice.common.error.GeneralErrorMessage;
import com.serhatacar.restaurantservice.exception.notfound.ItemNotFoundException;
import lombok.Getter;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

/**
 * @author Serhat Acar
 */

@Getter
public abstract class BaseEntityService<E extends BaseEntity, R extends JpaRepository<E, Long>> {

    private final R repository;

    protected BaseEntityService(R repository) {
        this.repository = repository;
    }

    public E save(E entity) {

        BaseAdditionalFields baseAdditionalFields = entity.getBaseAdditionalFields();
        if (baseAdditionalFields == null) {
            baseAdditionalFields = new BaseAdditionalFields();
        }

        LocalDateTime now = LocalDateTime.now();
        if (entity.getId() == null) {
            baseAdditionalFields.setCreatedAt(now);
        }

        baseAdditionalFields.setUpdatedAt(now);

        entity.setBaseAdditionalFields(baseAdditionalFields);

        entity = repository.save(entity);
        return entity;
    }

    public List<E> findAll() {
        return repository.findAll();
    }

    public Optional<E> findById(Long id) {
        return repository.findById(id);
    }

    public E findByIdWithControl(Long id) {
        Optional<E> optionalE = repository.findById(id);
        E entity;
        if (optionalE.isPresent()) {
            entity = optionalE.get();
        } else {
            throw new ItemNotFoundException(GeneralErrorMessage.ITEM_NOT_FOUND);
        }
        return entity;
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }


    public void delete(E entity) {
        repository.delete(entity);
    }

    public boolean existById(Long id) {
        return repository.existsById(id);
    }

}
