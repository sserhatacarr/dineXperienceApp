package com.serhatacar.userservice.controller;

import com.serhatacar.userservice.common.base.RestResponse;
import com.serhatacar.userservice.dto.request.UserReviewSaveRequest;
import com.serhatacar.userservice.dto.response.UserReviewDetailDTO;
import com.serhatacar.userservice.service.UserReviewService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Serhat Acar
 */
@RestController
@RequestMapping("/api/v1/user-reviews")
@RequiredArgsConstructor
public class UserReviewController {
    private final UserReviewService userReviewService;

    @PostMapping
    public ResponseEntity<RestResponse<UserReviewDetailDTO>> createUserReview(@Valid @RequestBody UserReviewSaveRequest request) {
        UserReviewDetailDTO userReviewDetailDTO = userReviewService.saveUserReview(request);
        return new ResponseEntity<>(RestResponse.of(userReviewDetailDTO, "User review created successfully"), HttpStatus.CREATED);
    }

}
