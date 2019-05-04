package mohit.movies.repository;

import mohit.movies.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by mohit on 04-May-19.
 */
@Repository
public interface MovieRepository extends JpaRepository<Movie, Integer> {
}
