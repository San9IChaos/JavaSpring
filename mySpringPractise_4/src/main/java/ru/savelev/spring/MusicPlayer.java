package ru.savelev.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class MusicPlayer {

    ClassicalMusic classicalMusic;
    RockMusic rockMusic;
    Random random = new Random();
    int randomNumber = random.nextInt(3);

    @Autowired
    public MusicPlayer(ClassicalMusic classicalMusic, RockMusic rockMusic) {
        this.classicalMusic = classicalMusic;
        this.rockMusic = rockMusic;
    }


    public void playMusic(MusicGenre musicGenre) {
        switch (musicGenre) {
            case ROCK:
                System.out.println(rockMusic.getSong().get(randomNumber));
                break;
            case CLASSICAL:
                System.out.println(classicalMusic.getSong().get(randomNumber));
                break;

        }
    }
}
