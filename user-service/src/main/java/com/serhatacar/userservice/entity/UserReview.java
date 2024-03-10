package com.serhatacar.userservice.entity;

import com.serhatacar.userservice.common.base.BaseEntity;
import com.serhatacar.userservice.entity.enums.UserRate;
import jakarta.persistence.*;
import lombok.*;

/**
 * @author Serhat Acar
 */
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "user_reviews")
public class UserReview extends BaseEntity {
    @Id
    @GeneratedValue
    private Long id;

    @Column (name="restaurant_id")
    private Long restaurantId;

    @Column(name = "comment")
    private String comment;

    @Column(name = "user_rate")
    private UserRate userRate;


    @JoinColumn(name = "user_id")
    private Long userId;




}
