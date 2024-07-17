package com.example.musicservice.config;

import com.example.musicservice.repository.*;
import com.example.musicservice.repository.impl.*;
import com.example.musicservice.services.PlaylistService;
import com.example.musicservice.services.TimeCapsuleService;
import com.example.musicservice.services.TrackService;
import com.example.musicservice.services.impl.PlaylistServiceImpl;
import com.example.musicservice.services.impl.TimeCapsuleServiceImpl;
import com.example.musicservice.services.impl.TrackServiceImpl;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

    @Bean
    public PlaylistRepository playlistRepository() {
        return new PlaylistRepositoryImpl();
    }

    @Bean
    public TimeCapsuleRepository timeCapsuleRepository() {
        return new TimeCapsuleRepositoryImpl();
    }

    @Bean
    public TrackRepository trackRepository() {
        return new TrackRepositoryImpl();
    }

    @Bean
    public UserRepository userRepository() {
        return new UserRepositoryImpl();
    }

    @Bean
    public PlaylistService playlistService() {
        return new PlaylistServiceImpl(playlistRepository(), trackRepository(), modelMapper());
    }

    @Bean
    public TimeCapsuleService timeCapsuleService() {
        return new TimeCapsuleServiceImpl(timeCapsuleRepository(), userRepository(), trackRepository(), modelMapper());
    }

    @Bean
    public TrackService trackService() {
        return new TrackServiceImpl(trackRepository(), modelMapper());
    }
}

