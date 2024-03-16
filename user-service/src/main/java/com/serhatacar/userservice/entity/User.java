package com.serhatacar.userservice.entity;

import com.serhatacar.userservice.entity.enums.Gender;
import com.serhatacar.userservice.entity.enums.Status;
import com.serhatacar.userservice.common.base.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Cascade;

import java.time.LocalDate;

/**
 * @author Serhat Acar
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name="users")
public class User extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", length = 50, nullable = false)
    private String name;

    @Column(name ="surname", length=50, nullable=false)
    private String surname;

    @Column(name="birth_date")
    private LocalDate birthDate;

    @Column (name ="email",length=100, nullable=false)
    private String email;

    @Enumerated(EnumType.STRING)
    @Column (name="gender", length=30)
    private Gender gender;

    @Enumerated(EnumType.STRING)
    @Column (name="user_status", length=30, nullable=false)
    private Status userStatus = Status.ACTIVE;

    @Column(name = "latitude", nullable = false)
    private double latitude;

    @Column(name = "longitude", nullable = false)
    private double longitude;

}
