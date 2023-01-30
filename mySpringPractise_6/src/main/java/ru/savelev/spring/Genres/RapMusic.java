package ru.savelev.spring.Genres;

import ru.savelev.spring.Music;

import java.util.ArrayList;
import java.util.List;

public class RapMusic implements Music {

    @Override
    public String getSong() {

        return "Miyagi - Captain";
    }
}
