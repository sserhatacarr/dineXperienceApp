package com.serhatacar.userservice.entity;

import com.serhatacar.userservice.common.base.BaseEntity;
import com.serhatacar.userservice.entity.enums.Rate;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author Serhat Acar
 */
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

    @Column(name = "rate")
    private Rate rate;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;




}
