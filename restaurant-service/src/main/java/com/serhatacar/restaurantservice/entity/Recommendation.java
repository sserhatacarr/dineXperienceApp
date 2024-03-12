package com.serhatacar.restaurantservice.entity;

import com.serhatacar.restaurantservice.common.base.BaseEntity;
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
@Table(name = "recommendations")

public class Recommendation extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long userId;
    private double score;
    @ManyToOne
    @JoinColumn(name = "restaurant_id")
    private Restaurant restaurant;

}
