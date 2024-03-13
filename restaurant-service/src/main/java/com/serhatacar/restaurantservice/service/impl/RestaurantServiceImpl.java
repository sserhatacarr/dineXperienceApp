package com.serhatacar.restaurantservice.service.impl;

import com.serhatacar.restaurantservice.dto.request.RestaurantSaveRequest;
import com.serhatacar.restaurantservice.dto.request.RestaurantUpdateRequest;
import com.serhatacar.restaurantservice.dto.response.RestaurantDTO;
import com.serhatacar.restaurantservice.entity.Restaurant;
import com.serhatacar.restaurantservice.mapper.RestaurantMapper;
import com.serhatacar.restaurantservice.service.RestaurantService;
import com.serhatacar.restaurantservice.service.entityservice.RestaurantEntityService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @author Serhat Acar
 */
@Service
@RequiredArgsConstructor
public class RestaurantServiceImpl implements RestaurantService {

    private final RestaurantEntityService restaurantEntityService;
    private final RestaurantMapper restaurantMapper;


    @Override
    public RestaurantDTO saveRestaurant(RestaurantSaveRequest request) {

        Restaurant restaurant = restaurantMapper.convertToRestaurant(request);
        restaurantEntityService.save(restaurant);
        return restaurantMapper.convertToRestaurantDTO(restaurant);
    }

    @Override
    public Iterable<RestaurantDTO> getAllRestaurants() {
        return restaurantMapper.convertToRestaurantDTOList(restaurantEntityService.findAll());
    }

    @Override
    public RestaurantDTO getRestaurantById(String id) {
        return restaurantMapper.convertToRestaurantDTO(restaurantEntityService.findByIdWithControl(id));
    }

    @Override
    public RestaurantDTO updateRestaurant(RestaurantUpdateRequest request) {
        Restaurant restaurant = restaurantEntityService.findByIdWithControl(request.id());
        restaurantMapper.updateRestaurantFields(restaurant, request);
        restaurantEntityService.save(restaurant);
        return restaurantMapper.convertToRestaurantDTO(restaurant);
    }

    @Override
    public void deleteRestaurant(String id) {
        Restaurant restaurant = restaurantEntityService.findByIdWithControl(id);
        restaurantEntityService.delete(restaurant);

    }
}
