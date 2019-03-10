package mohit.movies.controller;

import mohit.movies.model.Movie;
import mohit.movies.service.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * Created by miles19 on 10-Mar-19.
 */
@RestController
@RequestMapping("/api/movies")
public class MovieController {
    @Autowired
    private MovieRepository movieRepository;

    @GetMapping("")
    public Page<Movie> getMovies(Pageable pageable) {
        return movieRepository.findAll(pageable);
    }
}
