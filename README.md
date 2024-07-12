# Music Service

Этот проект представляет собой базу данных для музыкального сервиса, который должен позволять пользователям создавать плейлисты, музыкальные капсулы времени, вести музыкальный дневник и прослушивать редкие и забытые треки. Проект разрабатывается с использованием Spring Data и PostgreSQL.

## Технологии

- **Spring Boot**
- **Spring Data JPA**
- **PostgreSQL**
- **Jakarta Persistence API**

### Примеры сущностей

```sql
@MappedSuperclass
public abstract class BaseEntity {

    protected Long id;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
```
```sql
@Entity
@Table(name = "playlist_track")
public class PlaylistTrack extends BaseEntity {

    private Playlist playlist;
    private Track track;

    public PlaylistTrack(Playlist playlist, Track track) {
        this.playlist = playlist;
        this.track = track;
    }

    protected PlaylistTrack() {}

    @ManyToOne
    @JoinColumn(name = "playlist_id")
    public Playlist getPlaylist() {
        return playlist;
    }

    public void setPlaylist(Playlist playlist) {
        this.playlist = playlist;
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
```
### ERD
![MusicService](https://github.com/user-attachments/assets/ff00091f-d744-467f-9d88-83ad80a39d29)

