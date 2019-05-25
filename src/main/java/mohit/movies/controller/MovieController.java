package mohit.movies.controller;

import mohit.movies.model.Movie;
import mohit.movies.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;


/**
 * Created by mohit on 10-Mar-19.
 */
@RestController
@RequestMapping("/api/movies")
public class MovieController {
    @Autowired
    private MovieService movieService;

    @GetMapping("")
    public Page<Movie> getMovies(Pageable pageable) {
        return movieService.getMovies(pageable);
    }

    @GetMapping("/{id}")
    public Movie getMovieById(@PathVariable Integer id){
        Optional<Movie> movie = movieService.getMovieById(id);
        if (!movie.isPresent()) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Movie not found");
        }
        return movie.get();
    }

    @PostMapping("")
    public Movie addNewMovie(@RequestBody Movie movie) {
        return movieService.addNewMovie(movie);
    }

//    @PutMapping("/{id}")
//    public Movie updateMovie(@RequestBody Movie movie) {
//        return movieService.addNewMovie(movie);
//    }
}
