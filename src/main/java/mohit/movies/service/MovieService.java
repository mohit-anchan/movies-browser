package mohit.movies.service;

import mohit.movies.model.Movie;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

/**
 * Created by mohit on 10-Mar-19.
 */

public interface MovieService{

    Page<Movie> getMovies(Pageable pageable);

    Optional<Movie> getMovieById(Integer id);

    Movie addNewMovie(Movie movie);
}
