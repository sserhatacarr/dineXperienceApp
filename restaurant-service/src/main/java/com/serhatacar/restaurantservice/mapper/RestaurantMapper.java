package com.serhatacar.restaurantservice.mapper;

import com.serhatacar.restaurantservice.dto.request.RestaurantSaveRequest;
import com.serhatacar.restaurantservice.dto.request.RestaurantUpdateRequest;
import com.serhatacar.restaurantservice.dto.response.RestaurantDTO;
import com.serhatacar.restaurantservice.entity.Restaurant;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.ReportingPolicy;

import java.util.List;

/**
 * @author Serhat Acar
 */
@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface RestaurantMapper {

    Restaurant convertToRestaurant(RestaurantSaveRequest request);

    RestaurantDTO convertToRestaurantDTO(Restaurant restaurant);

    @Mapping(target = "id", ignore = true)
    void updateRestaurantFields(@MappingTarget Restaurant restaurant, RestaurantUpdateRequest request);

    List<RestaurantDTO> convertToRestaurantDTOList(List<Restaurant> restaurantList);
}
