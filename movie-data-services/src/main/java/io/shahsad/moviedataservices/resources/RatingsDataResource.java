package io.shahsad.moviedataservices.resources;

import io.shahsad.moviedataservices.models.Rating;
import io.shahsad.moviedataservices.models.UserRating;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/ratingsdata")
public class RatingsDataResource {
    @RequestMapping("/movies/{movieId}")
    public Rating getRating(@PathVariable("movieId") String movieId){
        return new  Rating(movieId,4);
    }

    @RequestMapping("/user/{userId}")
    public UserRating getUserRating(@PathVariable("userId") String userId){
        /*List<Rating> ratings = Arrays.asList(
                new Rating("test1",4),
                new Rating("test2",3),
                new Rating("test3",5)
        );
        UserRating userRating = new UserRating();
        userRating.setUserRating(ratings);
        return userRating;*/
        UserRating userRating = new UserRating();
        userRating.initData(userId);
        return userRating;



    }
}
