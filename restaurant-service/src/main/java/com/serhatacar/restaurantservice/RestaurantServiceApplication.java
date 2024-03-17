package com.serhatacar.restaurantservice;

import com.serhatacar.restaurantservice.entity.Restaurant;
import com.serhatacar.restaurantservice.repository.RestaurantRepository;
import com.serhatacar.restaurantservice.util.JsonUtil;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
@EnableFeignClients
public class RestaurantServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(RestaurantServiceApplication.class, args);
    }

    // CommandLineRunner is a simple Spring Boot interface with a run method. It gets called just before SpringApplication.run(…) completes.
    // It is used to perform any actions before the application starts.
    // In this case, we are using it to load the restaurants from the restaurants.json file into the database.
    @Bean
    CommandLineRunner runner(RestaurantRepository restaurantRepository) {
        return args -> {
            if (restaurantRepository.count() == 0) {
                List<Restaurant> users = JsonUtil.readRestaurantsFromJson();
                restaurantRepository.saveAll(users);
            }
        };
    }

}