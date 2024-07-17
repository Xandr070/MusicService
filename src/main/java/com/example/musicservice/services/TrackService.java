package com.example.musicservice.services;

import com.example.musicservice.dto.TrackDTO;

import java.util.List;

public interface TrackService {

    List<TrackDTO> getRareTracks();

    List<TrackDTO> getTracksByGenre(String genre);

    TrackDTO rateTrack(Long trackId, int rating);

}
