package com.metsoft.ecommerce.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "creation_date")
    private Date creationDate;



    @ManyToMany()
    @JoinTable(
            name = "order_items",
            joinColumns = @JoinColumn(name = "orderItem_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id"))
    private List<Product> products;



}
