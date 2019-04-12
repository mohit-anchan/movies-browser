package mohit.movies.service;

import mohit.movies.model.Movie;
import mohit.movies.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 * Created by Awaneesh on 4/12/2019.
 */

@Service
public class MovieServiceImpl implements MovieService {

    @Autowired
    private MovieRepository movieRepository;

    @Override
    public Page<Movie> getMovies(Pageable pageable) {
        return movieRepository.findAll(pageable);
    }

    @Override
    @Cacheable(value = "MasterServices")
    public Movie getMovieById(Integer id) {
        return movieRepository.findById(id).orElse(null);
    }
}
