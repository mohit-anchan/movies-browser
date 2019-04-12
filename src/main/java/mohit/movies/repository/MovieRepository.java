package mohit.movies.repository;

import mohit.movies.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by miles19 on 10-Mar-19.
 */
@Repository
public interface MovieRepository extends JpaRepository<Movie, Integer>{

    Movie findByName(String name);
}
