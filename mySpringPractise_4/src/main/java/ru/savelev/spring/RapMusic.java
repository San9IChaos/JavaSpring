package ru.savelev.spring;

import java.util.ArrayList;
import java.util.List;

public class RapMusic implements Music {
    List<String> songs = new ArrayList<>();
    {
        songs.add("Miyagi - Captain");
        songs.add("Eminem - Till I Collapse");
        songs.add("Oxxxymiron - Fata Morgana");
    }
    @Override
    public List<String> getSong() {
        return songs;
    }
}
