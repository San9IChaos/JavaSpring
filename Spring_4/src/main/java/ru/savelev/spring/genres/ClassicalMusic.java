package ru.savelev.spring.genres;

import ru.savelev.spring.Music;

import java.util.ArrayList;
import java.util.List;


public class ClassicalMusic implements Music {

    @Override
    public List<String> getSong() {
        return songs;
    }

    public List<String> songs = new ArrayList<>();

    {
        songs.add("Hungarian Rhapsody");
        songs.add("Bethoven Rhapsody");
        songs.add("Chaikovsky");
    }
}
