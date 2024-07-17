package com.example.musicservice.services;

import com.example.musicservice.services.dto.TimeCapsuleDTO;
import com.example.musicservice.services.dto.TrackDTO;

import java.util.List;

public interface TimeCapsuleService {

    TimeCapsuleDTO createTimeCapsule(TimeCapsuleDTO timeCapsuleDTO);

    TimeCapsuleDTO getTimeCapsuleById(Long id);

    TimeCapsuleDTO addTracksToTimeCapsule(Long id, List<TrackDTO> trackDTOs);

    TimeCapsuleDTO shareTimeCapsule(Long timeCapsuleId, List<Long> userIds);

    TimeCapsuleDTO unshareTimeCapsule(Long timeCapsuleId, List<Long> userIds);

}
