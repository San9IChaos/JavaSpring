package ru.savelev.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class MusicPlayer {
   private Music music1;
   private Music music2;
   Random random = new Random();
    @Autowired
    public MusicPlayer(@Qualifier("rockMusic") Music music1,
                       @Qualifier("rapMusic") Music music2) {
        this.music1 = music1;
        this.music2 = music2;
    }

    public void playMusic(MusicEnum musicEnum) {
        int randomInt = random.nextInt(3);

        if(musicEnum.equals(MusicEnum.ROCK)) {
            System.out.println("Playing: " + music1.getSong().get(randomInt));
        }
        else if(musicEnum.equals(MusicEnum.RAP)) {
            System.out.println("Playing: " + music2.getSong().get(randomInt));
        }

    }
}
