package com.serhatacar.userservice.service;

import com.serhatacar.userservice.client.RestaurantClient;
import com.serhatacar.userservice.common.base.RestResponse;
import com.serhatacar.userservice.dto.response.RestaurantDTO;
import com.serhatacar.userservice.dto.response.UserReviewDetailDTO;
import com.serhatacar.userservice.entity.UserReview;
import com.serhatacar.userservice.entity.enums.Status;
import com.serhatacar.userservice.mapper.UserReviewMapper;
import com.serhatacar.userservice.service.entityservice.UserReviewEntityService;
import com.serhatacar.userservice.service.impl.UserReviewServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

/**
 * @author Serhat Acar
 */

public class UserReviewServiceImplTest {

    @InjectMocks
    private UserReviewServiceImpl userReviewService;

    @Mock
    private UserReviewEntityService userReviewEntityService;

    @Mock
    private RestaurantClient restaurantClient;

    @Mock
    private UserReviewMapper userReviewMapper;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetAllUserReviews() {

        // Arrange
        UserReview userReview = new UserReview();
        RestaurantDTO restaurantDTO = new RestaurantDTO(
                "1",
                "Test Restaurant",
                "Test Address",
                "1234567890",
                "test@test.com",
                "Test Description",
                "www.test.com",
                "9:00 - 18:00",
                new BigDecimal("4.5"),
                Status.ACTIVE
        );
        when(userReviewEntityService.findAll()).thenReturn(Collections.singletonList(userReview));
        RestResponse<List<RestaurantDTO>> restResponse = new RestResponse<>(Collections.singletonList(restaurantDTO), true, "Success");
        doReturn(ResponseEntity.ok(restResponse)).when(restaurantClient).getAllRestaurants();
        when(userReviewMapper.toUserReviewDetailList(Collections.singletonList(userReview), Collections.singletonList(restaurantDTO)))
                .thenReturn(Collections.singletonList(new UserReviewDetailDTO(
                        1L,
                        null,
                        "1",
                        "Test Restaurant",
                        "Test Comment",
                        new BigDecimal("4.5")
                )));

        // Act
        List<UserReviewDetailDTO> result = userReviewService.getAllUserReviews();

        // Assert
        assertEquals(1, result.size());
        verify(userReviewEntityService, times(1)).findAll();
        verify(restaurantClient, times(1)).getAllRestaurants();
        verify(userReviewMapper, times(1)).toUserReviewDetailList(Collections.singletonList(userReview), Collections.singletonList(restaurantDTO));
    }

    @Test
    public void testGetUserReviewById() {

        // Arrange
        Long id = 1L;
        UserReview userReview = new UserReview();
        RestaurantDTO restaurantDTO = new RestaurantDTO(
                "1",
                "Test Restaurant",
                "Test Address",
                "1234567890",
                "emaill",
                "Test Description",
                "www.test.com",
                "9:00 - 18:00",
                new BigDecimal("4.5"),
                Status.ACTIVE
        );
        when(userReviewEntityService.findByIdWithControl(id)).thenReturn(userReview);
        RestResponse<RestaurantDTO> restResponse = new RestResponse<>(restaurantDTO, true, "Success");
        doReturn(ResponseEntity.ok(restResponse)).when(restaurantClient).getRestaurantById("1");
        when(userReviewMapper.toUserReviewDetail(userReview, restaurantDTO))
                .thenReturn(new UserReviewDetailDTO(
                        1L,
                        null,
                        "1",
                        "Test Restaurant",
                        "Test Comment",
                        new BigDecimal("4.5")
                ));
    }

    @Test
    public void testGetUserReviewsByUserId() {

        // Arrange
        Long userId = 1L;
        UserReview userReview = new UserReview();
        RestaurantDTO restaurantDTO = new RestaurantDTO(
                "1",
                "Test Restaurant",
                "Test Address",
                "1234567890",
                "email",
                "Test Description",
                "www.test.com",
                "9:00 - 18:00",
                new BigDecimal("4.5"),
                Status.ACTIVE
        );
        when(userReviewEntityService.findByUserId(userId)).thenReturn(Collections.singletonList(userReview));
        RestResponse<List<RestaurantDTO>> restResponse = new RestResponse<>(Collections.singletonList(restaurantDTO), true, "Success");
        doReturn(ResponseEntity.ok(restResponse)).when(restaurantClient).getAllRestaurants();
        when(userReviewMapper.toUserReviewDetailList(Collections.singletonList(userReview), Collections.singletonList(restaurantDTO)))
                .thenReturn(Collections.singletonList(new UserReviewDetailDTO(
                        1L,
                        null,
                        "1",
                        "Test Restaurant",
                        "Test Comment",
                        new BigDecimal("4.5")
                )));
    }

    @Test
    public void testGetUserReviewsByRestaurantId() {

        // Arrange
        String restaurantId = "1";
        UserReview userReview = new UserReview();
        RestaurantDTO restaurantDTO = new RestaurantDTO(
                "1",
                "Test Restaurant",
                "Test Address",
                "1234567890",
                "email",
                "Test Description",
                "www.test.com",
                "9:00 - 18:00",
                new BigDecimal("4.5"),
                Status.ACTIVE
        );
        when(userReviewEntityService.findByRestaurantId(restaurantId)).thenReturn(Collections.singletonList(userReview));
        RestResponse<RestaurantDTO> restResponse = new RestResponse<>(restaurantDTO, true, "Success");
        doReturn(ResponseEntity.ok(restResponse)).when(restaurantClient).getRestaurantById(restaurantId);
        when(userReviewMapper.toUserReviewDetailList(Collections.singletonList(userReview), Collections.singletonList(restaurantDTO)))
                .thenReturn(Collections.singletonList(new UserReviewDetailDTO(
                        1L,
                        null,
                        "1",
                        "Test Restaurant",
                        "Test Comment",
                        new BigDecimal("4.5")
                )));
    }

    @Test
    public void testEditUserReview() {

        // Arrange
        UserReview userReview = new UserReview();
        RestaurantDTO restaurantDTO = new RestaurantDTO(
                "1",
                "Test Restaurant",
                "Test Address",
                "1234567890",
                "email",
                "Test Description",
                "www.test.com",
                "9:00 - 18:00",
                new BigDecimal("4.5"),
                Status.ACTIVE
        );
        when(userReviewEntityService.findByIdWithControl(1L)).thenReturn(userReview);
        when(userReviewEntityService.save(userReview)).thenReturn(userReview);
        RestResponse<RestaurantDTO> restResponse = new RestResponse<>(restaurantDTO, true, "Success");
        doReturn(ResponseEntity.ok(restResponse)).when(restaurantClient).getRestaurantById("1");
        when(userReviewMapper.toUserReviewDetail(userReview, restaurantDTO))
                .thenReturn(new UserReviewDetailDTO(
                        1L,
                        null,
                        "1",
                        "Test Restaurant",
                        "Test Comment",
                        new BigDecimal("4.5")
                ));
    }

    @Test
    public void testDeleteUserReview() {

        // Arrange
        UserReview userReview = new UserReview();
        when(userReviewEntityService.findByIdWithControl(1L)).thenReturn(userReview);
        doNothing().when(userReviewEntityService).deleteById(1L);
    }
}
