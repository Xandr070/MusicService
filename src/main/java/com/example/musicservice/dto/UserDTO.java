package com.example.musicservice.dto;

import java.util.List;

public class UserDTO {
    private Long id;
    private String name;
    private List<PlaylistDTO> playlists;
    private List<TimeCapsuleDTO> timeCapsules;
    private List<MusicDiaryDTO> diary;

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

    public List<MusicDiaryDTO> getDiary() {
        return diary;
    }

    public void setDiary(List<MusicDiaryDTO> diary) {
        this.diary = diary;
    }
}
