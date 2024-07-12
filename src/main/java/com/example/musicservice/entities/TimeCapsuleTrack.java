package com.example.musicservice.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "time_capsule_track")
public class TimeCapsuleTrack extends BaseEntity {

    private TimeCapsule timeCapsule;
    private Track track;

    public TimeCapsuleTrack(TimeCapsule timeCapsule, Track track) {
        this.timeCapsule = timeCapsule;
        this.track = track;
    }

    protected TimeCapsuleTrack() {}

    @ManyToOne
    @JoinColumn(name = "time_capsule_id")
    public TimeCapsule getTimeCapsule() {
        return timeCapsule;
    }

    public void setTimeCapsule(TimeCapsule timeCapsule) {
        this.timeCapsule = timeCapsule;
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
