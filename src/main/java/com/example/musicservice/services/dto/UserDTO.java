package com.example.musicservice.services.dto;

import java.util.List;

public class UserDTO {
    private Long id;
    private String name;
    private List<PlaylistDTO> playlists;
    private List<TimeCapsuleDTO> timeCapsules;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<PlaylistDTO> getPlaylists() {
        return playlists;
    }

    public void setPlaylists(List<PlaylistDTO> playlists) {
        this.playlists = playlists;
    }

    public List<TimeCapsuleDTO> getTimeCapsules() {
        return timeCapsules;
    }

    public void setTimeCapsules(List<TimeCapsuleDTO> timeCapsules) {
        this.timeCapsules = timeCapsules;
    }
}
