package com.metin.swagger.example.resource;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class DirectorController {

    @GetMapping({"/directors/{directorId}"})
    public Director getDirector(@PathVariable Integer directorId) {

        return createDirectorList().get(directorId);
    }

    @DeleteMapping("/directors/{movieId}")
    public List<Director> deleteDirector(@PathVariable Integer directorId) {

        List<Director> list = new ArrayList<>();

        Map<Integer, Director> directorList = createDirectorList();
        directorList.remove(directorId);

        for (Director director: directorList.values()) {
            list.add(director);
        }

        return list;
    }

    @PutMapping("/directors/{directorId}")
    public Director updateDirector(@PathVariable Integer directorId, @RequestBody Director directorParam) {

        List<Director> list = new ArrayList<>();

        Map<Integer, Director> personList = createDirectorList();
        Director director = personList.replace(directorId, directorParam);

        return director;
    }

    private Map<Integer, Director> createDirectorList() {

        Map<Integer, Director> personList = new HashMap<>();
        personList.put(1, new Director(1, "Stanley", "Kubrick", getMovieList(1)));
        personList.put(1, new Director(2, "David", "Lynch", getMovieList(2)));

        return personList;
    }

    private List<Movie> getMovieList(int directorId){

        List<Movie> movieList = new ArrayList<>();

        if (directorId == 1){
            movieList.add(new Movie(1, 9, "Otomatik Portakal"));
            movieList.add(new Movie(2, 8, "Full Metal Jacket"));
        } else {
            movieList.add(new Movie(1, 7, "Inland Empire"));
            movieList.add(new Movie(2, 7.5, "Hollyshorts Greeting"));
        }

        return movieList;
    }
}

