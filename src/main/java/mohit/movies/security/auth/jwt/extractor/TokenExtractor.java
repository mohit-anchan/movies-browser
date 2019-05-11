package mohit.movies.security.auth.jwt.extractor;

/**
 * Implementations of this interface should always return raw base-64 encoded
 * representation of JWT JwtTokenFactory.
 *
 * Created by mohit on 04-May-19.
 */
public interface TokenExtractor {

    public String extract(String payload);
}
