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

    @Column(name = "restaurant_id", length = 50, nullable = false)
    private String restaurantId;

    @Column(name = "comment", length = 500, nullable = false)
    private String comment;

    @Column(name = "user_rate", nullable = false, precision = 3, scale = 2)
    private BigDecimal userRate;

    @JoinColumn(name = "user_id", nullable = false)
    @ManyToOne
    private User user;


}
