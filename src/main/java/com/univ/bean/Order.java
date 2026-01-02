package com.univ.bean;

import java.util.Date;
import java.util.List;
import jakarta.persistence.*;

@Entity
@Table(name="Orders")
public class Order {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;  // Unique order ID
    
    private String user_name;
    
    @ElementCollection
    @CollectionTable(name = "order_items", joinColumns = @JoinColumn(name = "order_id"))
    
    @Column(name = "product_id")
    private List<Integer> productIds;  // List of product IDs
    
    private Date order_date;
    
    private int total_price;

    // Constructors
    public Order() {}

    public Order(String user_name, List<Integer> productIds, Date order_date, int total_price) {
        this.user_name = user_name;
        this.productIds = productIds;
        this.order_date = order_date;
        this.total_price = total_price;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public List<Integer> getProductIds() {
        return productIds;
    }

    public void setProductIds(List<Integer> productIds) {
        this.productIds = productIds;
    }

    public Date getOrder_date() {
        return order_date;
    }

    public void setOrder_date(Date order_date) {
        this.order_date = order_date;
    }

    public int getTotal_price() {
        return total_price;
    }

    public void setTotal_price(int total_price) {
        this.total_price = total_price;
    }

    @Override
    public String toString() {
        return "Order [id=" + id + ", user_name=" + user_name + ", productIds=" + productIds 
               + ", order_date=" + order_date + ", total_price=" + total_price + "]";
    }
}
