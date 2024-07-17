package com.example.musicservice.services.impl;

import com.example.musicservice.services.dto.TrackDTO;
import com.example.musicservice.entities.Track;
import com.example.musicservice.repository.TrackRepository;
import com.example.musicservice.services.TrackService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TrackServiceImpl implements TrackService {

    private final TrackRepository trackRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public TrackServiceImpl(TrackRepository trackRepository, ModelMapper modelMapper) {
        this.trackRepository = trackRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<TrackDTO> getRareTracks() {
        List<Track> rareTracks = trackRepository.findAll().stream()
                .filter(track -> track.calculateRarity() > 50) // Пример фильтрации по редкости
                .collect(Collectors.toList());
        return mapToTrackDTOList(rareTracks);
    }

    @Override
    public List<TrackDTO> getTracksByGenre(String genre) {
        List<Track> tracks = trackRepository.findByGenre(genre);
        return mapToTrackDTOList(tracks);
    }

    @Override
    public TrackDTO rateTrack(Long trackId, int rating) {
        Track track = trackRepository.findById(trackId)
                .orElseThrow(() -> new RuntimeException("Track not found"));
        track.setRating(rating);
        Track savedTrack = trackRepository.save(track);
        return modelMapper.map(savedTrack, TrackDTO.class);
    }

    private List<TrackDTO> mapToTrackDTOList(List<Track> tracks) {
        return tracks.stream()
                .map(track -> modelMapper.map(track, TrackDTO.class))
                .collect(Collectors.toList());
    }
}
