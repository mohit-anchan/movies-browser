package mohit.movies.security.auth.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import mohit.movies.security.auth.JwtAuthenticationToken;
import mohit.movies.security.auth.jwt.token.RawAccessJwtToken;
import mohit.movies.security.config.JwtSettings;
import mohit.movies.security.model.UserContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

/**
 * JwtAuthenticationProvider has the following responsibilities:
 *
 * 1. Verify the access token's signature
 * 2. Extract identity and authorization claims from Access token and use them to create UserContext
 * 3. If Access token is malformed, expired or simply if token is not signed with the appropriate signing key Authentication exception will be thrown
 *
 * Created by mohit on 04-May-19.
 */
@Component
public class JwtAuthenticationProvider implements AuthenticationProvider {
    private final JwtSettings jwtSettings;

    @Autowired
    public JwtAuthenticationProvider(JwtSettings jwtSettings) {
        this.jwtSettings = jwtSettings;
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        RawAccessJwtToken rawAccessToken = (RawAccessJwtToken) authentication.getCredentials();

        /* Retrieving palyload (jwsClaims) from token */
        Jws<Claims> jwsClaims = rawAccessToken.parseClaims(jwtSettings.getTokenSigningKey());
        String subject = jwsClaims.getBody().getSubject();  //user name
        List<String> scopes = jwsClaims.getBody().get("scopes", List.class); //user roles
        List<GrantedAuthority> authorities = scopes.stream()
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());

        UserContext context = UserContext.create(subject, authorities);

        return new JwtAuthenticationToken(context, context.getAuthorities());
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return (JwtAuthenticationToken.class.isAssignableFrom(authentication));
    }
}
