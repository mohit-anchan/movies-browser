package mohit.movies.service;

import mohit.movies.model.User;

import java.util.Optional;

/**
 * Created by mohit on 05-May-19.
 */
public interface UserService {
    public Optional<User> getByUsername(String username);
}
