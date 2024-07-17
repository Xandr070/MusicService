package com.example.musicservice.entities;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "users")
public class User extends BaseEntity {

    private String name;
    private List<Playlist> playlists;
    private List<TimeCapsule> timeCapsules;

    public User(String name, List<Playlist> playlists, List<TimeCapsule> timeCapsules) {
        this.name = name;
        this.playlists = playlists;
        this.timeCapsules = timeCapsules;
    }

    protected User() {}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    public List<Playlist> getPlaylists() {
        return playlists;
    }

    public void setPlaylists(List<Playlist> playlists) {
        this.playlists = playlists;
    }

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    public List<TimeCapsule> getTimeCapsules() {
        return timeCapsules;
    }

    public void setTimeCapsules(List<TimeCapsule> timeCapsules) {
        this.timeCapsules = timeCapsules;
    }
}
