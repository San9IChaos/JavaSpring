package ru.savelev.spring;

import org.springframework.beans.factory.annotation.Value;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MusicPlayer {
    Random random = new Random();
    int randomInt = random.nextInt(3);
    private List<Music> musicList = new ArrayList<>();

    @Value("${musicPlayer.name}")
    private String name;

    @Value("${musicPlayer.volume}")
    private int volume;

    public String getName() {
        return name;
    }

    public int getVolume() {
        return volume;
    }

    public MusicPlayer(List<Music> musicList) {
        this.musicList = musicList;
    }

    public String playMusic() {
        return "Playing: " + musicList.get(random.nextInt(musicList.size())).getSong().get(randomInt)
                + " with volume " + this.volume;
    }
}
