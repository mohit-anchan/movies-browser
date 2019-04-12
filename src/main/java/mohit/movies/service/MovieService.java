package mohit.movies.service;

import mohit.movies.model.Movie;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Created by Awaneesh on 4/12/2019.
 */
public interface MovieService {
    Page<Movie> getMovies(Pageable pageable);
    Movie getMovieById(Integer id);
}
