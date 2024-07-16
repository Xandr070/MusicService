package com.example.musicservice.services;

import com.example.musicservice.dto.PlaylistDTO;
import com.example.musicservice.dto.TrackDTO;

import java.util.List;

public interface PlaylistService {

    PlaylistDTO createPlaylist(PlaylistDTO playlistDTO);

    PlaylistDTO getPlaylistById(Long id);

    PlaylistDTO updatePlaylist(Long id, PlaylistDTO playlistDTO);

    void deletePlaylist(Long id);

    PlaylistDTO addTracksToPlaylist(Long id, List<TrackDTO> trackDTOs);

    void removeTrackFromPlaylist(Long playlistId, Long trackId);
}
