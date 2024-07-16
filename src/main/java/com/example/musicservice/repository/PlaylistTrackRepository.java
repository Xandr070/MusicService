package com.example.musicservice.repository;

import com.example.musicservice.entities.PlaylistTrack;
import com.example.musicservice.entities.Playlist;
import com.example.musicservice.entities.Track;

import java.util.List;

public interface PlaylistTrackRepository {

    PlaylistTrack save(PlaylistTrack playlistTrack);

    List<PlaylistTrack> findByPlaylist(Playlist playlist);

    List<PlaylistTrack> findByTrack(Track track);

    void delete(PlaylistTrack playlistTrack);
}
