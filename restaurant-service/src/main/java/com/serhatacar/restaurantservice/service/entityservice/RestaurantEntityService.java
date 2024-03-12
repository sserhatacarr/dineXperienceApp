package com.serhatacar.restaurantservice.service.entityservice;

import com.serhatacar.restaurantservice.common.error.GeneralErrorMessage;
import com.serhatacar.restaurantservice.entity.Restaurant;
import com.serhatacar.restaurantservice.exception.notfound.ItemNotFoundException;
import com.serhatacar.restaurantservice.repository.RestaurantRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Serhat Acar
 */
@Service
public class RestaurantEntityService extends BaseEntityService<Restaurant, RestaurantRepository> {

    protected RestaurantEntityService(RestaurantRepository repository) {
        super(repository);
    }

    @Override
    public Restaurant findByIdWithControl(Long id) {
        return getRepository().findById(id).orElseThrow(() -> new ItemNotFoundException(GeneralErrorMessage.RESTAURANT_NOT_FOUND));
    }

    public List<Restaurant> getAllRestaurants() {
        return getRepository().findAll();
    }
}
