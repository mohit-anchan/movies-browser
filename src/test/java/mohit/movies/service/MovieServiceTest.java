package mohit.movies.service;

import mohit.movies.model.Movie;
import mohit.movies.repository.MovieRepository;
import mohit.movies.utils.MockPageImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

/**
 * Created by mohit on 11-May-19.
 */
@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
public class MovieServiceTest {
    /**
     * The @Mock annotation creates a mock implementation for the class it is annotated with.
     */
    @InjectMocks
    MovieServiceImpl movieService;

    /**
     * @InjectMocks also creates the mock implementation, additionally injects the dependent mocks that are marked with
     * the annotations @Mock into it.
     */
    @Mock
    MovieRepository movieRepository;

    Pageable pageable;

    @Before
    public void init() {
        pageable = Mockito.mock(Pageable.class);
    }

    @Test
    public void test_getMovies() {
        List<Movie> test_data = Arrays.asList(
                new Movie(2019, "Test Movie 1", "English"),
                new Movie(2018, "Test Movie 2", "Spanish"),
                new Movie(2017, "Test Movie 3", "Hindi")
        );

        Page<Movie> movies_page = new MockPageImpl<>(test_data);
        when(movieRepository.findAll(pageable)).thenReturn(movies_page);

        Page<Movie> movies = movieService.getMovies(pageable);

        assertEquals(3, movies.getTotalElements());

        /* Verify that the repository method was called exactly once */
        verify(movieRepository, times(1)).findAll(pageable);
    }

    @Test
    public void test_getMovieById() {
        int movieId = 1;
        Movie expected = new Movie(2019, "Test Movie 1", "English");
        expected.setId(movieId);

        when(movieRepository.findById(movieId)).thenReturn(Optional.of(expected));

        Optional<Movie> movie = movieService.getMovieById(movieId);

        assertEquals(expected.getName(), movie.get().getName());
        verify(movieRepository, times(1)).findById(movieId);
    }
}

