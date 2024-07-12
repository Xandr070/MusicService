package com.example.musicservice.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "playlist_track")
public class PlaylistTrack {

    public PlaylistTrack(Long id, Playlist playlist, Track track) {
        this.id = id;
        this.playlist = playlist;
        this.track = track;
    }

    private Long id;
    private Playlist playlist;
    private Track track;

    protected PlaylistTrack() {}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @ManyToOne
    @JoinColumn(name = "playlist_id")
    public Playlist getPlaylist() {
        return playlist;
    }

    public void setPlaylist(Playlist playlist) {
        this.playlist = playlist;
    }

    @ManyToOne
    @JoinColumn(name = "track_id")
    public Track getTrack() {
        return track;
    }

    public void setTrack(Track track) {
        this.track = track;
    }
}
