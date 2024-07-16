package com.example.musicservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class PlaylistNotFoundException extends RuntimeException {

    public PlaylistNotFoundException(Long playlistId) {
        super("Playlist not found with id: " + playlistId);
    }
}
