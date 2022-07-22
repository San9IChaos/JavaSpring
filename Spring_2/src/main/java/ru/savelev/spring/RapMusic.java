package ru.savelev.spring;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class RapMusic implements Music {
    @Override
    public List<String> getSong() {

        return songs;
    }

    private List<String> songs = new ArrayList<>();
    {
        songs.add("Captain");
        songs.add("Till I Collapse");
        songs.add("Dezhavu");

    }
}
