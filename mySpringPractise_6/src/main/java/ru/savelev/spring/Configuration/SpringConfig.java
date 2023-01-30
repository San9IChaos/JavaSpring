package ru.savelev.spring.Configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import ru.savelev.spring.Genres.ClassicalMusic;
import ru.savelev.spring.Genres.RapMusic;
import ru.savelev.spring.Genres.RockMusic;
import ru.savelev.spring.Music;
import ru.savelev.spring.MusicPlayer;

import java.util.Arrays;
import java.util.List;

@Configuration
@PropertySource("classpath:musicPlayer.properties")
public class SpringConfig {
    @Bean
    public ClassicalMusic classicalMusic() {
        return new ClassicalMusic();
    }
    @Bean
    public RockMusic rockMusic() {
        return new RockMusic();
    }
    @Bean
    public RapMusic rapMusic() {
        return new RapMusic();
    }
    @Bean
    public List<Music> musicList() {
        return Arrays.asList(rapMusic(), rockMusic(), classicalMusic());
    }
    @Bean
    public MusicPlayer musicPlayer() {
        return new MusicPlayer(musicList());
    }
}
