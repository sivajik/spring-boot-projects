package com.sprms.microservices.product.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;

@Document(value = "product")
@Builder
@Data
@AllArgsConstructor
public class Product {
    @Id
    private String id;

    private String name;
    private String description;
    private BigDecimal price;
}
