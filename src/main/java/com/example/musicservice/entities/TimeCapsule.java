package com.example.musicservice.entities;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "time_capsules")
public class TimeCapsule extends BaseEntity {

    private String name;
    private String description;
    private String creationDate;
    private String deliveryDate;
    private User user;
    private List<Track> tracks;

    public TimeCapsule(String name, String description, String creationDate, String deliveryDate, User user, List<Track> tracks) {
        this.name = name;
        this.description = description;
        this.creationDate = creationDate;
        this.deliveryDate = deliveryDate;
        this.user = user;
        this.tracks = tracks;
    }

    protected TimeCapsule() {}

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
}
