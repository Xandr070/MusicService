# Music Service

Этот проект представляет собой базу данных для музыкального сервиса, который должен позволять пользователям создавать плейлисты, музыкальные капсулы времени, вести музыкальный дневник и прослушивать редкие и забытые треки. Проект разрабатывается с использованием Spring Data и PostgreSQL.

## Технологии

- **Spring Boot**
- **Spring Data JPA**
- **PostgreSQL**
- **Jakarta Persistence API**

### Примеры сущностей

```sql
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Playlist> playlists;
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<TimeCapsule> timeCapsules;
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<MusicDiary> diary;
    // Getters and setters
}
```
```sql
@Entity
@Table(name = "playlists")
public class Playlist {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;
    private String creationDate;
    private String tags;
    private String event;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    @OneToMany(mappedBy = "playlist", cascade = CascadeType.ALL)
    private List<PlaylistTrack> playlistTracks;
    // Getters and setters
}
```
### ERD
![image](https://github.com/Xandr070/MusicService/assets/129608390/42b41a86-f58f-43f6-8aba-c331f82d9eb5)
