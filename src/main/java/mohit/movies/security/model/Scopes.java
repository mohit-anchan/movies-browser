package mohit.movies.security.model;

/**
 * Created by mohit on 05-May-19.
 */
public enum Scopes {
    REFRESH_TOKEN;

    public String authority() {
        return "ROLE_" + this.name();
    }
}
