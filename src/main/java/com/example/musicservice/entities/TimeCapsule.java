package com.example.musicservice.entities;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "time_capsules")
public class TimeCapsule extends BaseEntity {

    private String name;
    private String description;
    private LocalDateTime creationDate;
    private LocalDateTime deliveryDate;
    private User user;
    private List<Track> tracks;
    private List<User> sharedWith;

    public TimeCapsule(String name, String description, LocalDateTime deliveryDate, User user, List<Track> tracks) {
        this.name = name;
        this.description = description;
        this.creationDate = LocalDateTime.now();
        this.deliveryDate = deliveryDate;
        this.user = user;
        this.tracks = tracks;
        this.sharedWith = new ArrayList<>();
    }

    protected TimeCapsule() {
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

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

    public LocalDateTime getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(LocalDateTime deliveryDate) {
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

    @ManyToMany
    @JoinTable(
            name = "time_capsule_track",
            joinColumns = @JoinColumn(name = "time_capsule_id"),
            inverseJoinColumns = @JoinColumn(name = "track_id")
    )
    public List<Track> getTracks() {
        return tracks;
    }

    public void setTracks(List<Track> tracks) {
        this.tracks = tracks;
    }

    @ManyToMany
    @JoinTable(
            name = "time_capsule_shared_with",
            joinColumns = @JoinColumn(name = "time_capsule_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id")
    )
    public List<User> getSharedWith() {
        return sharedWith;
    }

    public void setSharedWith(List<User> sharedWith) {
        this.sharedWith = sharedWith;
    }
}
