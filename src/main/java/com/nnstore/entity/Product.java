package com.nnstore.entity;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "Products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    @ManyToOne
    @JoinColumn(name = "categoryId")
    Category category;

    @Column(name = "Name")
    private String name;

    @Column(name = "Description")
    private String description;

    @Column(name = "Quantity")
    private Integer quantity;

    @Column(name = "Price")
    private Double price;

    @Column(name = "Sale")
    private Integer sale;

    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "dd/mm/yyyy")
    @Column(name = "CreateDate")
    private Date CreatedDate;

    @Column(name = "Thumnail")
    private String thumnail;

    @OneToMany(mappedBy = "product")
    private List<OrderDetail> orderDetails = new ArrayList<>();

    @ManyToMany(mappedBy = "favoriteProducts")
    private List<User> favoriteUsers = new ArrayList<>();

    @ManyToMany(mappedBy = "viewProducts")
    private List<User> viewUsers = new ArrayList<>();

    @ManyToMany(mappedBy = "remindProducts")
    private List<User> remindUsers = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getSale() {
        return sale;
    }

    public void setSale(Integer sale) {
        this.sale = sale;
    }

    public Date getCreatedDate() {
        return CreatedDate;
    }

    public void setCreatedDate(Date createdDate) {
        CreatedDate = createdDate;
    }

    public String getThumnail() {
        return thumnail;
    }

    public void setThumnail(String thumnail) {
        this.thumnail = thumnail;
    }

    public List<OrderDetail> getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(List<OrderDetail> orderDetails) {
        this.orderDetails = orderDetails;
    }

    public List<User> getFavoriteUsers() {
        return favoriteUsers;
    }

    public void setFavoriteUsers(List<User> favoriteUsers) {
        this.favoriteUsers = favoriteUsers;
    }

    public List<User> getViewUsers() {
        return viewUsers;
    }

    public void setViewUsers(List<User> viewUsers) {
        this.viewUsers = viewUsers;
    }

    public List<User> getRemindUsers() {
        return remindUsers;
    }

    public void setRemindUsers(List<User> remindUsers) {
        this.remindUsers = remindUsers;
    }
}
