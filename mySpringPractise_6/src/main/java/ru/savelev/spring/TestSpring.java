package ru.savelev.spring;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.savelev.spring.Configuration.SpringConfig;

public class TestSpring {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);

        MusicPlayer musicPlayer = context.getBean("musicPlayer", MusicPlayer.class);

        musicPlayer.playMusic();

        context.close();
    }
}
