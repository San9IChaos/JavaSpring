package ru.savelev.spring.genres;

import ru.savelev.spring.Music;

import java.util.ArrayList;
import java.util.List;

public class RapMusic implements Music {

        @Override
        public List<String> getSong() {
            return songs;
        }

        private List<String> songs = new ArrayList<>();

    {
        songs.add("Captain");
        songs.add("Dezhavu");
        songs.add("Till I Collapse");
    }

    }

