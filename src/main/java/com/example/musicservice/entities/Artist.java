package com.example.musicservice.entities;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "artists")
public class Artist {

    protected Artist() {}

    public Artist(Long id, String name, String biography, String genre, String tags, List<Album> albums, List<Track> tracks) {
        this.id = id;
        this.name = name;
        this.biography = biography;
        this.genre = genre;
        this.tags = tags;
        this.albums = albums;
        this.tracks = tracks;
    }

    private Long id;
    private String name;
    private String biography;
    private String genre;
    private String tags;
    private List<Album> albums;
    private List<Track> tracks;

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

    public String getBiography() {
        return biography;
    }

    public void setBiography(String biography) {
        this.biography = biography;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    @OneToMany(mappedBy = "artist", cascade = CascadeType.ALL)
    public List<Album> getAlbums() {
        return albums;
    }

    public void setAlbums(List<Album> albums) {
        this.albums = albums;
    }

    @OneToMany(mappedBy = "artist", cascade = CascadeType.ALL)
    public List<Track> getTracks() {
        return tracks;
    }

    public void setTracks(List<Track> tracks) {
        this.tracks = tracks;
    }
}
