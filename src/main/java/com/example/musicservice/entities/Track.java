package com.example.musicservice.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "tracks")
public class Track {

    public Track(Long id, String title, String duration, String genre, String releaseDate, String tags, int playCount, Album album, Artist artist, List<Playlist> playlists) {
        this.id = id;
        this.title = title;
        this.duration = duration;
        this.genre = genre;
        this.releaseDate = releaseDate;
        this.tags = tags;
        this.playCount = playCount;
        this.album = album;
        this.artist = artist;
        this.playlists = playlists;
    }

    protected Track() {}

    private Long id;
    private String title;
    private String duration;
    private String genre;
    private String releaseDate;
    private String tags;
    private int playCount;
    private Album album;
    private Artist artist;
    private List<Playlist> playlists;

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

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public int getPlayCount() {
        return playCount;
    }

    public void setPlayCount(int playCount) {
        this.playCount = playCount;
    }

    @ManyToOne
    @JoinColumn(name = "album_id")
    public Album getAlbum() {
        return album;
    }

    public void setAlbum(Album album) {
        this.album = album;
    }

    @ManyToOne
    @JoinColumn(name = "artist_id")
    public Artist getArtist() {
        return artist;
    }

    public void setArtist(Artist artist) {
        this.artist = artist;
    }

    @ManyToMany(mappedBy = "tracks")
    public List<Playlist> getPlaylists() {
        return playlists;
    }

    public void setPlaylists(List<Playlist> playlists) {
        this.playlists = playlists;
    }
}
