package com.example.musicservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class TrackNotFoundException extends RuntimeException {

    public TrackNotFoundException(Long trackId) {
        super("Track not found with id: " + trackId);
    }
}
