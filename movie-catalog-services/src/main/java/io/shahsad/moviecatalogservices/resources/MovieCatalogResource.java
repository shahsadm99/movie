package io.shahsad.moviecatalogservices.resources;

import io.shahsad.moviecatalogservices.models.CatalogItem;
import io.shahsad.moviecatalogservices.models.Movie;
import io.shahsad.moviecatalogservices.models.Rating;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequestMapping ("/catalog")
public class MovieCatalogResource {
    @Autowired
    private RestTemplate restTemplate;
    @RequestMapping("/{userId}")

    public List<CatalogItem> getCatalog(@PathVariable("userId") String userId){

        /// Removing since bean will inject the instance, Autowire is the consumer
        ///Bean and autowire are used to create multiple instance for rest, all use the same model
        //RestTemplate restTemplate = new RestTemplate();
        //restTemplate.getForObject("http://localhost:8082/movies/o", Movie.class);

        List<Rating> ratings = Arrays.asList(
                new Rating("test1",4),
                new Rating("test2",3),
                new Rating("test3",5)
        );

        return ratings.stream().map(rating -> {
                    Movie movie= restTemplate.getForObject("http://localhost:8082/movies/" + rating.getMovieId(), Movie.class);

                    return new CatalogItem(movie.getName(), "Test", rating.getRating());
                } )
                .collect(Collectors.toList());

        //return Collections.singletonList(new CatalogItem("The man from earth","Test",5));
    }
}
