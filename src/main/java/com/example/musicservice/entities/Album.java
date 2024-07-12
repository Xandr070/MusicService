package com.example.musicservice.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "albums")
public class Album {

    protected Album() {}

    public Album(Long id, String title, String releaseDate, String genre, String description, String tags, Artist artist, List<Track> tracks) {
        this.id = id;
        this.title = title;
        this.releaseDate = releaseDate;
        this.genre = genre;
        this.description = description;
        this.tags = tags;
        this.artist = artist;
        this.tracks = tracks;
    }

    private Long id;
    private String title;
    private String releaseDate;
    private String genre;
    private String description;
    private String tags;
    private Artist artist;
    private List<Track> tracks;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    @ManyToOne
    @JoinColumn(name = "artist_id")
    public Artist getArtist() {
        return artist;
    }

    public void setArtist(Artist artist) {
        this.artist = artist;
    }

    @OneToMany(mappedBy = "album", cascade = CascadeType.ALL)
    public List<Track> getTracks() {
        return tracks;
    }

    public void setTracks(List<Track> tracks) {
        this.tracks = tracks;
    }
}
