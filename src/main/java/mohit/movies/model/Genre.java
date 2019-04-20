package mohit.movies.model;

import javax.persistence.*;
import java.time.OffsetDateTime;
import java.util.Set;

/**
 * Created by mohit on 17-Mar-19.
 */
@Entity
@Table(name = "genre")
public class Genre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private OffsetDateTime createdOn;
    private OffsetDateTime lastUpdated;

    //Causes circular dependency
//    @ManyToMany
//    private Set<Movie> movies;

//    @ManyToMany(mappedBy = "genres")
//    private Set<Movie> movies;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public OffsetDateTime getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(OffsetDateTime createdOn) {
        this.createdOn = createdOn;
    }

    public OffsetDateTime getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(OffsetDateTime lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

//    public Set<Movie> getMovies() {
//        return movies;
//    }
//
//    public void setMovies(Set<Movie> movies) {
//        this.movies = movies;
//    }
}
