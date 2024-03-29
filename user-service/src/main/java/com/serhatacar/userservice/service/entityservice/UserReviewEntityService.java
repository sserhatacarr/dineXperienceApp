package com.serhatacar.userservice.service.entityservice;

import com.serhatacar.userservice.common.error.GeneralErrorMessage;
import com.serhatacar.userservice.entity.UserReview;
import com.serhatacar.userservice.exception.notfound.UserReviewNotFoundException;
import com.serhatacar.userservice.repository.UserReviewRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Serhat Acar
 */
@Service
public class UserReviewEntityService extends BaseEntityService<UserReview, UserReviewRepository> {
    protected UserReviewEntityService(UserReviewRepository repository) {
        super(repository);
    }

    @Override
    public UserReview findByIdWithControl(Long id) {
        return getRepository().findById(id).orElseThrow(() -> new UserReviewNotFoundException(GeneralErrorMessage.USER_REVIEW_NOT_FOUND));
    }

    public List<UserReview> findByUserId(Long userId) {
        return getRepository().findByUserId(userId);
    }

    public List<UserReview> findByRestaurantId(String restaurantId) {
        return getRepository().findByRestaurantId(restaurantId);
    }
}
