package mohit.movies.security.exceptions;

import org.springframework.security.authentication.AuthenticationServiceException;

/**
 * Created by mohit on 05-May-19.
 */
public class AuthMethodNotSupportedException extends AuthenticationServiceException {
    private static final long serialVersionUID = 3705043083010304496L;

    public AuthMethodNotSupportedException(String msg) {
        super(msg);
    }
}
