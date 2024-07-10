package com.example.musicservice.entities;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "time_capsules")
public class TimeCapsule {

    public TimeCapsule() {

    }

    public TimeCapsule(Long id, String name, String description, String creationDate, String deliveryDate, User user) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.creationDate = creationDate;
        this.deliveryDate = deliveryDate;
        this.user = user;
    }

    private Long id;
    private String name;
    private String description;
    private String creationDate;
    private String deliveryDate;
    private User user;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(String creationDate) {
        this.creationDate = creationDate;
    }

    public String getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(String deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    @ManyToOne
    @JoinColumn(name = "user_id")
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
