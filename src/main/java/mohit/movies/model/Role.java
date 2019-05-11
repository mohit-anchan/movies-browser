package mohit.movies.model;

/**
 * Created by mohit on 05-May-19.
 */
public enum Role {
    ADMIN, PREMIUM_MEMBER, MEMBER;

    public String authority() {
        return "ROLE_" + this.name();
    }
}
