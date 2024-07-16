package com.example.musicservice.services.impl;

import com.example.musicservice.dto.PlaylistDTO;
import com.example.musicservice.dto.TrackDTO;
import com.example.musicservice.entities.Playlist;
import com.example.musicservice.entities.PlaylistTrack;
import com.example.musicservice.entities.Track;
import com.example.musicservice.repository.PlaylistRepository;
import com.example.musicservice.repository.TrackRepository;
import com.example.musicservice.services.PlaylistService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PlaylistServiceImpl implements PlaylistService {

    private final PlaylistRepository playlistRepository;
    private final TrackRepository trackRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public PlaylistServiceImpl(PlaylistRepository playlistRepository, TrackRepository trackRepository, ModelMapper modelMapper) {
        this.playlistRepository = playlistRepository;
        this.trackRepository = trackRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    @Transactional
    public PlaylistDTO createPlaylist(PlaylistDTO playlistDTO) {
        Playlist playlist = modelMapper.map(playlistDTO, Playlist.class);
        Playlist savedPlaylist = playlistRepository.save(playlist);
        return modelMapper.map(savedPlaylist, PlaylistDTO.class);
    }

    @Override
    @Transactional(readOnly = true)
    public PlaylistDTO getPlaylistById(Long id) {
        Playlist playlist = playlistRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Playlist not found"));
        return modelMapper.map(playlist, PlaylistDTO.class);
    }

    @Override
    @Transactional
    public PlaylistDTO updatePlaylist(Long id, PlaylistDTO playlistDTO) {
        Playlist playlist = playlistRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Playlist not found"));
        modelMapper.map(playlistDTO, playlist);
        Playlist updatedPlaylist = playlistRepository.save(playlist);
        return modelMapper.map(updatedPlaylist, PlaylistDTO.class);
    }

    @Override
    @Transactional
    public void deletePlaylist(Long id) {
        playlistRepository.deleteById(id);
    }

    @Override
    @Transactional
    public PlaylistDTO addTracksToPlaylist(Long id, List<TrackDTO> trackDTOs) {
        Playlist playlist = playlistRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Playlist not found"));
        List<Track> tracks = trackDTOs.stream()
                .map(trackDTO -> trackRepository.findById(trackDTO.getId())
                        .orElseThrow(() -> new RuntimeException("Track not found")))
                .collect(Collectors.toList());
        playlist.getPlaylistTracks().addAll(tracks.stream()
                .map(track -> new PlaylistTrack(playlist, track))
                .collect(Collectors.toList()));
        Playlist updatedPlaylist = playlistRepository.save(playlist);
        return modelMapper.map(updatedPlaylist, PlaylistDTO.class);
    }

    @Override
    @Transactional
    public void removeTrackFromPlaylist(Long playlistId, Long trackId) {
        Playlist playlist = playlistRepository.findById(playlistId)
                .orElseThrow(() -> new RuntimeException("Playlist not found"));
        Track track = trackRepository.findById(trackId)
                .orElseThrow(() -> new RuntimeException("Track not found"));
        playlist.getPlaylistTracks().removeIf(playlistTrack -> playlistTrack.getTrack().equals(track));
        playlistRepository.save(playlist);
    }
}
