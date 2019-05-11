package mohit.movies.security.auth.jwt.token;

import mohit.movies.security.exceptions.JwtExpiredTokenException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import io.jsonwebtoken.*;
import org.springframework.security.authentication.BadCredentialsException;

/**
 * Created by mohit on 04-May-19.
 */
public class RawAccessJwtToken implements JwtToken {

    private static Logger logger = LoggerFactory.getLogger(RawAccessJwtToken.class);

    private String token;

    public RawAccessJwtToken(String token) {
        this.token = token;
    }

    /**
     * Parses and validates JWT JwtTokenFactory signature.
     *
     * @throws BadCredentialsException
     * @throws JwtExpiredTokenException
     *
     */
    public Jws<Claims> parseClaims(String signingKey) {
        try {
            return Jwts.parser().setSigningKey(signingKey).parseClaimsJws(this.token);
        } catch (UnsupportedJwtException | MalformedJwtException | IllegalArgumentException | SignatureException ex) {
            logger.error("Invalid JWT JwtTokenFactory", ex);
            throw new BadCredentialsException("Invalid JWT token: ", ex);
        } catch (ExpiredJwtException expiredEx) {
            logger.info("JWT JwtTokenFactory is expired", expiredEx);
            throw new JwtExpiredTokenException(this, "JWT JwtTokenFactory expired", expiredEx);
        }
    }

    @Override
    public String getToken() {
        return token;
    }
}
