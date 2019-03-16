
CREATE TABLE movie(
id SERIAL PRIMARY KEY,
name TEXT NOT NULL,
year INT NOT NULL,
language TEXT NOT NULL,
relase_date DATE NULL,
createdon TIMESTAMP WITH TIME ZONE NOT NULL default now(),
lastupdated TIMESTAMP WITH TIME ZONE NOT NULL default now()
);

CREATE TABLE genre(
id SERIAL PRIMARY KEY,
name TEXT NOT NULL,
createdon TIMESTAMP WITH TIME ZONE NOT NULL default now(),
CONSTRAINT genre_unq UNIQUE (name)
);

CREATE TABLE movie_genre(
movie_id bigint NOT NULL,
genre_id bigint NOT NULL,
CONSTRAINT movie_fk FOREIGN KEY (movie_id) REFERENCES movie(id),
CONSTRAINT genre_fk FOREIGN KEY (genre_id) REFERENCES genre(id),
CONSTRAINT movie_genre_unq UNIQUE (movie_id, genre_id)
);

INSERT INTO movie (year, name, language, relase_date) values (2012, 'The Dictator', 'English', '2012-05-16');
INSERT INTO movie (year, name, language, relase_date) values (2016, 'Brothers Grimbsy', 'English', '2016-02-24');
INSERT INTO movie (year, name, language, relase_date) values (2007, 'Borat', 'English', '2007-03-30');
INSERT INTO movie (year, name, language, relase_date) values (2002, 'Ali G Indahouse', 'English', '2002-03-22');
INSERT INTO movie (year, name, language, relase_date) values (2007, 'Epic Movie', 'English', '2007-01-26');
INSERT INTO movie (year, name, language, relase_date) values (2008, 'Disaster Movie', 'English', '2008-08-29');
INSERT INTO movie (year, name, language, relase_date) values (2008, 'You Dont Mess with the Zohan', 'English', '2008-06-06');

INSERT INTO genre (name) values ('Comedy');
INSERT INTO genre (name) values ('Mockumentary');

INSERT INTO movie_genre
    SELECT m.id, g.id FROM movie m, genre g
    WHERE m.name = 'The Dictator' and g.name = 'Comedy';

INSERT INTO movie_genre
  SELECT m.id, g.id FROM movie m, genre g
  WHERE m.name = 'Brothers Grimbsy' and g.name = 'Comedy';

INSERT INTO movie_genre
  SELECT m.id, g.id FROM movie m, genre g
  WHERE m.name = 'Borat' and g.name = 'Comedy';

INSERT INTO movie_genre
  SELECT m.id, g.id FROM movie m, genre g
  WHERE m.name = 'Borat' and g.name = 'Mockumentary';

INSERT INTO movie_genre
  SELECT m.id, g.id FROM movie m, genre g
  WHERE m.name = 'Ali G Indahouse' and g.name = 'Comedy';

INSERT INTO movie_genre
  SELECT m.id, g.id FROM movie m, genre g
  WHERE m.name = 'Epic Movie' and g.name = 'Comedy';

INSERT INTO movie_genre
  SELECT m.id, g.id FROM movie m, genre g
  WHERE m.name = 'Disaster Movie' and g.name = 'Comedy';

INSERT INTO movie_genre
  SELECT m.id, g.id FROM movie m, genre g
  WHERE m.name = 'You Dont Mess with the Zohan' and g.name = 'Comedy';
