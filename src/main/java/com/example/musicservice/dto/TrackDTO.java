package com.example.musicservice.dto;

import java.util.List;

public class TrackDTO {
    private Long id;
    private String title;
    private String duration;
    private String genre;
    private String releaseDate;
    private String tags;
    private int playCount;
    private AlbumDTO album;
    private ArtistDTO artist;
    private List<PlaylistTrackDTO> playlistTracks;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public int getPlayCount() {
        return playCount;
    }

    public void setPlayCount(int playCount) {
        this.playCount = playCount;
    }

    public AlbumDTO getAlbum() {
        return album;
    }

    public void setAlbum(AlbumDTO album) {
        this.album = album;
    }

    public ArtistDTO getArtist() {
        return artist;
    }

    public void setArtist(ArtistDTO artist) {
        this.artist = artist;
    }

    public List<PlaylistTrackDTO> getPlaylistTracks() {
        return playlistTracks;
    }

    public void setPlaylistTracks(List<PlaylistTrackDTO> playlistTracks) {
        this.playlistTracks = playlistTracks;
    }
}
