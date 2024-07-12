package com.example.musicservice.entities;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "playlists")
public class Playlist extends BaseEntity {

    private String title;
    private String description;
    private String creationDate;
    private String tags;
    private String event;
    private User user;
    private List<PlaylistTrack> playlistTracks;

    public Playlist(String title, String description, String creationDate, String tags, String event, User user, List<PlaylistTrack> playlistTracks) {
        this.title = title;
        this.description = description;
        this.creationDate = creationDate;
        this.tags = tags;
        this.event = event;
        this.user = user;
        this.playlistTracks = playlistTracks;
    }

    protected Playlist() {}

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }

    @ManyToOne
    @JoinColumn(name = "user_id")
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @OneToMany(mappedBy = "playlist", cascade = CascadeType.ALL)
    public List<PlaylistTrack> getPlaylistTracks() {
        return playlistTracks;
    }

    public void setPlaylistTracks(List<PlaylistTrack> playlistTracks) {
        this.playlistTracks = playlistTracks;
    }
}
