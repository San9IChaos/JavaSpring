package ru.savelev.spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import ru.savelev.spring.*;
import ru.savelev.spring.genres.ClassicalMusic;
import ru.savelev.spring.genres.RapMusic;
import ru.savelev.spring.genres.RockMusic;

import java.util.Arrays;
import java.util.List;

@Configuration
@ComponentScan("ru.savelev.spring")
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
    public MusicPlayer musicPlayer() {
        return new MusicPlayer(MusicList());
    }

    @Bean
    public Computer computer() {
        return new Computer(musicPlayer());
    }

    @Bean
    public List<Music> MusicList() {
        return Arrays.asList(rapMusic(),rockMusic(),classicalMusic());
    }


}
