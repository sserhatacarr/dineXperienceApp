package com.serhatacar.restaurantservice.repository;

import com.serhatacar.restaurantservice.entity.Restaurant;
import org.springframework.data.solr.repository.SolrCrudRepository;

/**
 * @author Serhat Acar
 */

public interface RestaurantRepository extends SolrCrudRepository<Restaurant, Long> {
}
