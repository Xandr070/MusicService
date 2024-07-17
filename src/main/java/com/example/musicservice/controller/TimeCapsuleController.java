package com.example.musicservice.controller;

import com.example.musicservice.dto.TimeCapsuleDTO;
import com.example.musicservice.dto.TrackDTO;
import com.example.musicservice.services.TimeCapsuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/time-capsules")
public class TimeCapsuleController {

    private final TimeCapsuleService timeCapsuleService;

    @Autowired
    public TimeCapsuleController(TimeCapsuleService timeCapsuleService) {
        this.timeCapsuleService = timeCapsuleService;
    }

    @PostMapping
    public ResponseEntity<TimeCapsuleDTO> createTimeCapsule(@RequestBody TimeCapsuleDTO timeCapsuleDTO) {
        TimeCapsuleDTO createdTimeCapsule = timeCapsuleService.createTimeCapsule(timeCapsuleDTO);
        return new ResponseEntity<>(createdTimeCapsule, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TimeCapsuleDTO> getTimeCapsuleById(@PathVariable Long id) {
        TimeCapsuleDTO timeCapsuleDTO = timeCapsuleService.getTimeCapsuleById(id);
        return ResponseEntity.ok(timeCapsuleDTO);
    }

    @PostMapping("/{id}/tracks")
    public ResponseEntity<TimeCapsuleDTO> addTracksToTimeCapsule(@PathVariable Long id, @RequestBody List<TrackDTO> trackDTOs) {
        TimeCapsuleDTO updatedTimeCapsule = timeCapsuleService.addTracksToTimeCapsule(id, trackDTOs);
        return ResponseEntity.ok(updatedTimeCapsule);
    }

    @PostMapping("/{id}/share")
    public ResponseEntity<TimeCapsuleDTO> shareTimeCapsule(@PathVariable Long id, @RequestBody List<Long> userIds) {
        TimeCapsuleDTO sharedTimeCapsule = timeCapsuleService.shareTimeCapsule(id, userIds);
        return ResponseEntity.ok(sharedTimeCapsule);
    }

    @PostMapping("/{id}/unshare")
    public ResponseEntity<TimeCapsuleDTO> unshareTimeCapsule(@PathVariable Long id, @RequestBody List<Long> userIds) {
        TimeCapsuleDTO unsharedTimeCapsule = timeCapsuleService.unshareTimeCapsule(id, userIds);
        return ResponseEntity.ok(unsharedTimeCapsule);
    }
}
