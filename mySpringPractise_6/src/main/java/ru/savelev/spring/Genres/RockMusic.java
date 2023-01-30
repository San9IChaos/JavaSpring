package ru.savelev.spring.Genres;

import org.springframework.stereotype.Component;
import ru.savelev.spring.Music;


public class RockMusic implements Music {
    @Override
    public String getSong() {
        return "Wind cries Mary";
    }
}
