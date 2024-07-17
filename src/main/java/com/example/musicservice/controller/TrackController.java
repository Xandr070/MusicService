package com.example.musicservice.controller;

import com.example.musicservice.dto.TrackDTO;
import com.example.musicservice.services.TrackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tracks")
public class TrackController {

    private final TrackService trackService;

    @Autowired
    public TrackController(TrackService trackService) {
        this.trackService = trackService;
    }

    @GetMapping("/rare")
    public ResponseEntity<List<TrackDTO>> getRareTracks() {
        List<TrackDTO> rareTracks = trackService.getRareTracks();
        return new ResponseEntity<>(rareTracks, HttpStatus.OK);
    }

    @GetMapping("/genre/{genre}")
    public ResponseEntity<List<TrackDTO>> getTracksByGenre(@PathVariable String genre) {
        List<TrackDTO> tracks = trackService.getTracksByGenre(genre);
        return new ResponseEntity<>(tracks, HttpStatus.OK);
    }

    @PostMapping("/{trackId}/rate/{rating}")
    public ResponseEntity<TrackDTO> rateTrack(@PathVariable Long trackId, @PathVariable int rating) {
        TrackDTO ratedTrack = trackService.rateTrack(trackId, rating);
        return new ResponseEntity<>(ratedTrack, HttpStatus.OK);
    }
}
