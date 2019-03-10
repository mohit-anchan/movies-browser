package mohit.movies.service;

import mohit.movies.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by miles19 on 10-Mar-19.
 */
@Repository
public interface MovieRepository extends JpaRepository<Movie, Integer>{
}
