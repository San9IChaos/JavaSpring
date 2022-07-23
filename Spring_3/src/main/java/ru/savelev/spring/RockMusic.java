package ru.savelev.spring;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class RockMusic implements Music{
    @Override
    public List<String> getSong() {

        return songs;
    }

    private List<String> songs = new ArrayList<>();
    {
        songs.add("Wind cries Mary");
        songs.add("Wrecked");
        songs.add("Natural");

    }


}
