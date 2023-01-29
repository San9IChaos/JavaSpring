package ru.savelev.spring;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class RockMusic implements Music{
    List<String> songs = new ArrayList<>();

    {
        songs.add("Wind cries Mary");
        songs.add("КиШ - дом лесника");
        songs.add("КиШ - ели мясо мужики");
    }
    @Override
    public List<String> getSong() {
        return songs;
    }
}
