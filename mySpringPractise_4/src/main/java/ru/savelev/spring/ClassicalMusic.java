package ru.savelev.spring;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ClassicalMusic implements Music {
    List<String> songs = new ArrayList<>();
    {
        songs.add("Hungarian Rhapsody");
        songs.add("Mocart");
        songs.add("Lebedinoe Ozero");
    }
    @Override
    public List<String> getSong() {
        return songs;
    }
}
