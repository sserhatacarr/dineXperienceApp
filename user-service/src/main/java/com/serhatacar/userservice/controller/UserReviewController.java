package com.serhatacar.userservice.controller;

import com.serhatacar.userservice.common.base.RestResponse;
import com.serhatacar.userservice.dto.request.UserReviewSaveRequest;
import com.serhatacar.userservice.dto.request.UserReviewUpdateRequest;
import com.serhatacar.userservice.dto.response.UserReviewDetailDTO;
import com.serhatacar.userservice.service.UserReviewService;
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

    @GetMapping("/{id}")
    public ResponseEntity<RestResponse<UserReviewDetailDTO>> getUserReviewById(@PathVariable Long id) {
        UserReviewDetailDTO userReviewDetailDTO = userReviewService.getUserReviewById(id);
        return new ResponseEntity<>(RestResponse.of(userReviewDetailDTO, "User review listed successfully"), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<RestResponse<UserReviewDetailDTO>> createUserReview(@Valid @RequestBody UserReviewSaveRequest request) {
        UserReviewDetailDTO userReviewDetailDTO = userReviewService.saveUserReview(request);
        return new ResponseEntity<>(RestResponse.of(userReviewDetailDTO, "User review created successfully"), HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public ResponseEntity<RestResponse<List<UserReviewDetailDTO>>> getAllUserReviews() {
        List<UserReviewDetailDTO > userReviewDetailDTOs = userReviewService.getAllUserReviews();
        return new ResponseEntity<>(RestResponse.of(userReviewDetailDTOs, "All user reviews listed successfully"), HttpStatus.OK);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<RestResponse<List<UserReviewDetailDTO>>> getUserReviewsByUserId(@PathVariable Long userId) {
        List<UserReviewDetailDTO > userReviewDetailDTOs = userReviewService.getUserReviewsByUserId(userId);
        return new ResponseEntity<>(RestResponse.of(userReviewDetailDTOs, "User reviews listed successfully"), HttpStatus.OK);
    }

    @GetMapping("/restaurant/{restaurantId}")
    public ResponseEntity<RestResponse<List<UserReviewDetailDTO>>> getUserReviewsByRestaurantId(@PathVariable Long restaurantId) {
        List<UserReviewDetailDTO> userReviewDetailDTOs = userReviewService.getUserReviewsByRestaurantId(restaurantId);
        return new ResponseEntity<>(RestResponse.of(userReviewDetailDTOs, "User reviews listed successfully"), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<RestResponse<UserReviewDetailDTO>> editUserReview(@Valid @RequestBody UserReviewUpdateRequest request) {
        UserReviewDetailDTO userReviewDetailDTO = userReviewService.editUserReview(request);
        return new ResponseEntity<>(RestResponse.of(userReviewDetailDTO, "User review updated successfully"), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<RestResponse<String>> deleteUserReview(@PathVariable Long id) {
        userReviewService.deleteUserReview(id);
        return new ResponseEntity<>(RestResponse.empty("User review deleted successfully"), HttpStatus.OK);
    }

}
