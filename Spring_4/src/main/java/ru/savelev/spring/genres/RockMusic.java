package ru.savelev.spring.genres;

import ru.savelev.spring.Music;

import java.util.ArrayList;
import java.util.List;


public class RockMusic implements Music {
    @Override
    public List<String> getSong() {
        return songs;
    }

    private List<String> songs = new ArrayList<>();
    {
        songs.add("Wind cries Mary");
        songs.add("Believe");
        songs.add("Thunder");

    }
}
