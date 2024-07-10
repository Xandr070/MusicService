package com.example.musicservice.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "users")
public class User {

    public User(Long id, String name, List<Playlist> playlists, List<TimeCapsule> timeCapsules, List<MusicDiary> diary) {
        this.id = id;
        this.name = name;
        this.playlists = playlists;
        this.timeCapsules = timeCapsules;
        this.diary = diary;
    }

    public User() {
    }

    private Long id;
    private String name;
    private List<Playlist> playlists;
    private List<TimeCapsule> timeCapsules;
    private List<MusicDiary> diary;

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

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    public List<MusicDiary> getDiary() {
        return diary;
    }

    public void setDiary(List<MusicDiary> diary) {
        this.diary = diary;
    }
}
