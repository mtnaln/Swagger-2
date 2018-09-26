package com.metin.swagger.example.resource;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
@Api(value = "Movie REST API", description = "Movie REST Endpoints")
public class MovieController {

    @ApiResponses(
            value = {
                @ApiResponse(code = 150, message = "code is 150"),
                @ApiResponse(code = 500, message = "server error...")
            }
    )
    @ApiOperation(value = "List of Movie")
    @GetMapping({"/", "/movies"})
    public List<Movie> getMovieList() {

        List<Movie> list = new ArrayList<>();

        Map<Integer, Movie> movieList = createMovieList();
        for (Movie movie : movieList.values()) {
            list.add(movie);
        }

        return list;
    }

    @ApiOperation(value = "Display selected Movie")
    @GetMapping({"/movies/{movieId}"})
    public Movie getMovie(@PathVariable Integer movieId) {

        return createMovieList().get(movieId);
    }

    @PostMapping("/movies")
    public List<Movie> addMovie(@RequestBody Movie movieParam) {

        List<Movie> list = new ArrayList<>();

        Map<Integer, Movie> movieList = createMovieList();
        movieList.put(3, movieParam);

        for (Movie movie : movieList.values()) {
            list.add(movie);
        }

        return list;
    }

    private Map<Integer, Movie> createMovieList() {

        Map<Integer, Movie> movieList = new HashMap<>();
        movieList.put(1, new Movie(1, 8.5, "Ring"));
        movieList.put(2, new Movie(2, 9, "The Prestige"));

        return movieList;
    }
}
