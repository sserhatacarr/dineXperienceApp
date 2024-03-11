package com.serhatacar.userservice.entity;

import com.serhatacar.userservice.common.base.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "restaurant_id")
    private Long restaurantId;

    @Column(name = "comment")
    private String comment;

    @Column(name = "user_rate")
    private BigDecimal userRate;

    @JoinColumn(name = "user_id")
    @ManyToOne
    private User user;


}
