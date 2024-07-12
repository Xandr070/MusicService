package com.example.musicservice.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "music_diary")
public class MusicDiary extends BaseEntity {

    private String entryDate;
    private String note;
    private User user;
    private Track track;

    public MusicDiary(String entryDate, String note, User user, Track track) {
        this.entryDate = entryDate;
        this.note = note;
        this.user = user;
        this.track = track;
    }

    protected MusicDiary() {}

    public String getEntryDate() {
        return entryDate;
    }

    public void setEntryDate(String entryDate) {
        this.entryDate = entryDate;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @ManyToOne
    @JoinColumn(name = "user_id")
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @ManyToOne
    @JoinColumn(name = "track_id")
    public Track getTrack() {
        return track;
    }

    public void setTrack(Track track) {
        this.track = track;
    }
}
