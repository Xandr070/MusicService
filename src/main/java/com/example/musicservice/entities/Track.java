package com.example.musicservice.entities;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "tracks")
public class Track extends BaseEntity {

    private String title;
    private String duration;
    private String genre;
    private LocalDateTime releaseDate;
    private String tags;
    private int playCount;
    private int rating;
    private Album album;
    private Artist artist;
    private List<Playlist> playlists;
    private List<TimeCapsule> timeCapsules;

    public Track(String title, String duration, String genre, String tags, int playCount, int rating, Album album, Artist artist, List<Playlist> playlists, List<TimeCapsule> timeCapsules) {
        this.title = title;
        this.duration = duration;
        this.genre = genre;
        this.releaseDate = LocalDateTime.now();
        this.tags = tags;
        this.playCount = playCount;
        this.rating = rating;
        this.album = album;
        this.artist = artist;
        this.playlists = playlists;
        this.timeCapsules = timeCapsules;
    }

    protected Track() {}

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

    public LocalDateTime getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDateTime releaseDate) {
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

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
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

    @ManyToMany(mappedBy = "tracks")
    public List<TimeCapsule> getTimeCapsules() {
        return timeCapsules;
    }

    public void setTimeCapsules(List<TimeCapsule> timeCapsules) {
        this.timeCapsules = timeCapsules;
    }

    // Метод для вычисления редкости трека
    @Transient
    public int calculateRarity() {
        // Простой пример вычисления: редкость = (количество прослушиваний / 100) * рейтинг
        return (playCount / 100) * rating;
    }
}
