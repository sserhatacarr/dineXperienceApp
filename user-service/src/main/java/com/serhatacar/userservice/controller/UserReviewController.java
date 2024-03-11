package com.serhatacar.userservice.controller;

import com.serhatacar.userservice.common.base.RestResponse;
import com.serhatacar.userservice.dto.request.UserReviewSaveRequest;
import com.serhatacar.userservice.dto.request.UserReviewUpdateRequest;
import com.serhatacar.userservice.dto.response.UserReviewDetailDTO;
import com.serhatacar.userservice.service.UserReviewService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Serhat Acar
 */
@RestController
@RequestMapping("/api/v1/user-reviews")
@RequiredArgsConstructor
public class UserReviewController {
    private final UserReviewService userReviewService;

    @Operation(summary = "GET request for user review by id", description = "Returns a user review by id <br>Accessible to admin users only.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Success"),
            @ApiResponse(responseCode = "404", description = "Not Found<br>-User review not found"),
            @ApiResponse(responseCode = "500", description = "Internal Server Error")
    })
    @GetMapping("/{id}")
    public ResponseEntity<RestResponse<UserReviewDetailDTO>> getUserReviewById(@PathVariable Long id) {
        UserReviewDetailDTO userReviewDetailDTO = userReviewService.getUserReviewById(id);
        return new ResponseEntity<>(RestResponse.of(userReviewDetailDTO, "User review listed successfully"), HttpStatus.OK);
    }

    @Operation(summary = "POST request to create user review", description = "Creates a user review <br>Accessible to all users.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Created"),
            @ApiResponse(responseCode = "400", description = "Bad Request<br>-Restaurant not found<br>-User not found"),
            @ApiResponse(responseCode = "500", description = "Internal Server Error")
    })
    @PostMapping
    public ResponseEntity<RestResponse<UserReviewDetailDTO>> createUserReview(@Valid @RequestBody UserReviewSaveRequest request) {
        UserReviewDetailDTO userReviewDetailDTO = userReviewService.saveUserReview(request);
        return new ResponseEntity<>(RestResponse.of(userReviewDetailDTO, "User review created successfully"), HttpStatus.CREATED);
    }

    @Operation(summary = "GET request for all user reviews", description = "Returns all user reviews <br>Accessible to admin users only.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Success"),
            @ApiResponse(responseCode = "500", description = "Internal Server Error")
    })
    @GetMapping("/all")
    public ResponseEntity<RestResponse<List<UserReviewDetailDTO>>> getAllUserReviews() {
        List<UserReviewDetailDTO > userReviewDetailDTOs = userReviewService.getAllUserReviews();
        return new ResponseEntity<>(RestResponse.of(userReviewDetailDTOs, "All user reviews listed successfully"), HttpStatus.OK);
    }

    @Operation(summary = "GET request for user reviews by user id", description = "Returns user reviews by user id <br>Accessible to admin users only.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Success"),
            @ApiResponse(responseCode = "404", description = "Not Found<br>-User not found"),
            @ApiResponse(responseCode = "500", description = "Internal Server Error")
    })
    @GetMapping("/user/{userId}")
    public ResponseEntity<RestResponse<List<UserReviewDetailDTO>>> getUserReviewsByUserId(@PathVariable Long userId) {
        List<UserReviewDetailDTO > userReviewDetailDTOs = userReviewService.getUserReviewsByUserId(userId);
        return new ResponseEntity<>(RestResponse.of(userReviewDetailDTOs, "User reviews listed successfully"), HttpStatus.OK);
    }

    @Operation(summary = "GET request for user reviews by restaurant id", description = "Returns user reviews by restaurant id <br>Accessible to admin users only.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Success"),
            @ApiResponse(responseCode = "404", description = "Not Found<br>-Restaurant not found"),
            @ApiResponse(responseCode = "500", description = "Internal Server Error")
    })
    @GetMapping("/restaurant/{restaurantId}")
    public ResponseEntity<RestResponse<List<UserReviewDetailDTO>>> getUserReviewsByRestaurantId(@PathVariable Long restaurantId) {
        List<UserReviewDetailDTO> userReviewDetailDTOs = userReviewService.getUserReviewsByRestaurantId(restaurantId);
        return new ResponseEntity<>(RestResponse.of(userReviewDetailDTOs, "User reviews listed successfully"), HttpStatus.OK);
    }

    @Operation(summary = "PUT request for user review", description = "Edits a user review <br>Accessible to admin users only.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Success"),
            @ApiResponse(responseCode = "400", description = "Bad Request<br>-User review not found"),
            @ApiResponse(responseCode = "500", description = "Internal Server Error")
    })
    @PutMapping
    public ResponseEntity<RestResponse<UserReviewDetailDTO>> editUserReview(@Valid @RequestBody UserReviewUpdateRequest request) {
        UserReviewDetailDTO userReviewDetailDTO = userReviewService.editUserReview(request);
        return new ResponseEntity<>(RestResponse.of(userReviewDetailDTO, "User review updated successfully"), HttpStatus.OK);
    }

    @Operation(summary = "DELETE request to delete a user review", description = "Deletes a user review <br>Accessible to admin users only.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Success"),
            @ApiResponse(responseCode = "400", description = "Bad Request<br>-User review not found"),
            @ApiResponse(responseCode = "500", description = "Internal Server Error")
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<RestResponse<String>> deleteUserReview(@PathVariable Long id) {
        userReviewService.deleteUserReview(id);
        return new ResponseEntity<>(RestResponse.empty("User review deleted successfully"), HttpStatus.OK);
    }
}
