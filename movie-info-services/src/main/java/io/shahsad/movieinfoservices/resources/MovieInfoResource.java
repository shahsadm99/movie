package io.shahsad.movieinfoservices.resources;


//import io.shahsad.movieinfoservices.models.InfoItem;
import io.shahsad.movieinfoservices.models.Movie;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/movies")
public class MovieInfoResource {
    @RequestMapping ("/{movieId}")
    public Movie getMovieInfo(@PathVariable("movieId") String movieId){
        return new Movie (movieId,"Name");
    }
}

