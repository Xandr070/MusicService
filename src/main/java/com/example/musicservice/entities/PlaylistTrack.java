package com.example.musicservice.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "playlist_track")
public class PlaylistTrack extends BaseEntity {

    private Playlist playlist;
    private Track track;

    public PlaylistTrack(Playlist playlist, Track track) {
        this.playlist = playlist;
        this.track = track;
    }

    protected PlaylistTrack() {}

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
