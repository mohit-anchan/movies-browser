package mohit.movies.security.auth.jwt.verifier;

/**
 * Created by mohit on 04-May-19.
 */
public interface TokenVerifier {
    public boolean verify(String jti);
}
