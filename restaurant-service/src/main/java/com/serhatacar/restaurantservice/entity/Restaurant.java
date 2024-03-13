package com.serhatacar.restaurantservice.entity;

import com.serhatacar.restaurantservice.entity.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import nonapi.io.github.classgraph.json.Id;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.solr.core.mapping.Indexed;
import org.springframework.data.solr.core.mapping.SolrDocument;

import java.time.LocalDateTime;

/**
 * @author Serhat Acar
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@SolrDocument(solrCoreName = "restaurants")
public class Restaurant {

    @Id
    @Indexed(name = "id", type = "string")
    private String id;

    @Indexed(name = "name", type = "string")
    private String name;

    @Indexed(name = "address", type = "string")
    private String address;

    @Indexed(name = "phone", type = "string")
    private String phone;

    @Indexed(name = "email", type = "string")
    private String email;

    @Indexed(name = "website", type = "string")
    private String website;

    @Indexed(name = "description", type = "string")
    private String description;

    @Indexed(name = "workingHours", type = "string")
    private String workingHours;

    @Indexed(name = "latitude", type = "pdouble")
    private double latitude;

    @Indexed(name = "longitude", type = "pdouble")
    private double longitude;

    @Indexed(name = "restaurantRate", type = "pdouble")
    private Double restaurantRate;

    @Indexed(name = "status", type = "string")
    private Status status;

    @Indexed(name = "createdAt", type = "pdate")
    @CreatedDate
    private LocalDateTime createdAt;

    @Indexed(name = "updatedAt", type = "pdate")
    @LastModifiedDate
    private LocalDateTime updatedAt;

    @Indexed(name = "creatorId", type = "plong")
    @CreatedBy
    private Long creatorId;

    @Indexed(name = "updatedId", type = "plong")
    @LastModifiedBy
    private Long updatedId;

}
