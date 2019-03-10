
ALTER TABLE movie
DROP COLUMN title;

UPDATE movie
SET year = 2012
WHERE name = 'The Dictator';

INSERT INTO movie (year, name, language) values (2016, 'Brothers Grimbsy', 'English');
INSERT INTO movie (year, name, language) values (2006, 'Borat', 'English');
INSERT INTO movie (year, name, language) values (2002, 'Ali G Indahouse', 'English');
INSERT INTO movie (year, name, language) values (2007, 'Epic Movie', 'English');
INSERT INTO movie (year, name, language) values (2008, 'Disaster Movie', 'English');
INSERT INTO movie (year, name, language) values (2008, 'You Don''t Mess with the Zohan', 'English');
