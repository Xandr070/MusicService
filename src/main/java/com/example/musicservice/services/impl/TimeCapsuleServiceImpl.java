package com.example.musicservice.services.impl;

import com.example.musicservice.dto.TimeCapsuleDTO;
import com.example.musicservice.dto.TrackDTO;
import com.example.musicservice.entities.TimeCapsule;
import com.example.musicservice.entities.Track;
import com.example.musicservice.entities.User;
import com.example.musicservice.repository.TimeCapsuleRepository;
import com.example.musicservice.repository.TrackRepository;
import com.example.musicservice.repository.UserRepository;
import com.example.musicservice.services.TimeCapsuleService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TimeCapsuleServiceImpl implements TimeCapsuleService {

    private final TimeCapsuleRepository timeCapsuleRepository;
    private final UserRepository userRepository;
    private final TrackRepository trackRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public TimeCapsuleServiceImpl(TimeCapsuleRepository timeCapsuleRepository, UserRepository userRepository, TrackRepository trackRepository, ModelMapper modelMapper) {
        this.timeCapsuleRepository = timeCapsuleRepository;
        this.userRepository = userRepository;
        this.trackRepository = trackRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    @Transactional
    public TimeCapsuleDTO createTimeCapsule(TimeCapsuleDTO timeCapsuleDTO) {
        User user = modelMapper.map(timeCapsuleDTO.getUser(), User.class);
        List<Track> tracks = timeCapsuleDTO.getTracks().stream()
                .map(trackDTO -> modelMapper.map(trackDTO, Track.class))
                .collect(Collectors.toList());

        TimeCapsule timeCapsule = new TimeCapsule(
                timeCapsuleDTO.getName(),
                timeCapsuleDTO.getDescription(),
                timeCapsuleDTO.getDeliveryDate(),
                user,
                tracks
        );

        TimeCapsule savedTimeCapsule = timeCapsuleRepository.save(timeCapsule);
        return modelMapper.map(savedTimeCapsule, TimeCapsuleDTO.class);
    }

    @Override
    @Transactional(readOnly = true)
    public TimeCapsuleDTO getTimeCapsuleById(Long id) {
        TimeCapsule timeCapsule = timeCapsuleRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Time Capsule not found"));
        return modelMapper.map(timeCapsule, TimeCapsuleDTO.class);
    }

    @Override
    @Transactional
    public TimeCapsuleDTO addTracksToTimeCapsule(Long id, List<TrackDTO> trackDTOs) {
        TimeCapsule timeCapsule = timeCapsuleRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Time Capsule not found"));

        List<Track> tracks = trackDTOs.stream()
                .map(trackDTO -> trackRepository.findById(trackDTO.getId())
                        .orElseThrow(() -> new RuntimeException("Track not found")))
                .toList();

        timeCapsule.getTracks().clear();
        timeCapsule.getTracks().addAll(tracks);

        TimeCapsule updatedTimeCapsule = timeCapsuleRepository.save(timeCapsule);
        return modelMapper.map(updatedTimeCapsule, TimeCapsuleDTO.class);
    }

    @Override
    @Transactional
    public TimeCapsuleDTO shareTimeCapsule(Long timeCapsuleId, List<Long> userIds) {
        TimeCapsule timeCapsule = timeCapsuleRepository.findById(timeCapsuleId)
                .orElseThrow(() -> new RuntimeException("Time Capsule not found"));

        List<User> users = userRepository.findAllById(userIds);
        timeCapsule.getSharedWith().addAll(users);

        TimeCapsule updatedTimeCapsule = timeCapsuleRepository.save(timeCapsule);
        return modelMapper.map(updatedTimeCapsule, TimeCapsuleDTO.class);
    }

    @Override
    @Transactional
    public TimeCapsuleDTO unshareTimeCapsule(Long timeCapsuleId, List<Long> userIds) {
        TimeCapsule timeCapsule = timeCapsuleRepository.findById(timeCapsuleId)
                .orElseThrow(() -> new RuntimeException("Time Capsule not found"));

        List<User> users = userRepository.findAllById(userIds);
        timeCapsule.getSharedWith().removeAll(users);

        TimeCapsule updatedTimeCapsule = timeCapsuleRepository.save(timeCapsule);
        return modelMapper.map(updatedTimeCapsule, TimeCapsuleDTO.class);
    }
}
