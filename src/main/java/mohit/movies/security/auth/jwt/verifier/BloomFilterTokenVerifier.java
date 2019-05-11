package mohit.movies.security.auth.jwt.verifier;

import org.springframework.stereotype.Component;

/**
 * This is dummy class. You should ideally implement your own TokenVerifier to check for revoked tokens.
 *
 * Created by mohit on 04-May-19.
 */
@Component
public class BloomFilterTokenVerifier implements TokenVerifier {
    @Override
    public boolean verify(String jti) {
        return true;
    }
}
