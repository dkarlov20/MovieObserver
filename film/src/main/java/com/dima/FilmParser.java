package com.dima;

import com.dima.models.Film;
import com.dima.models.FilmScreening;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

@Component
public class FilmParser {
    public Film parse(String path) {
        File file = new File(path);
        Film film = new Film();
        List<FilmScreening> filmScreeningList = new ArrayList<>();
        try (Scanner scanner = new Scanner(file)) {
            film.setName(file.getName().substring(0, file.getName().lastIndexOf(".")));
            film.setDuration(scanner.nextInt());
            film.setActive(scanner.nextBoolean());
            String[] filmScreenings = scanner.next().split(",");
            Arrays.stream(filmScreenings).forEach(s -> filmScreeningList.add(FilmScreening.builder().film(film).time(s).build()));
            film.setFilmScreenings(filmScreeningList);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return film;
    }
}
