
CREATE TABLE APP_USER(
id SERIAL PRIMARY KEY,
username TEXT NOT NULL,
password TEXT NOT NULL,
created_on TIMESTAMP WITH TIME ZONE NOT NULL default now(),
last_updated TIMESTAMP WITH TIME ZONE NOT NULL default now()
);

CREATE TABLE APP_USER_ROLE(
app_user_id int NOT NULL,
role TEXT NOT NULL,
created_on TIMESTAMP WITH TIME ZONE NOT NULL default now(),
last_updated TIMESTAMP WITH TIME ZONE NOT NULL default now(),
CONSTRAINT app_user_role_fk FOREIGN KEY (app_user_id) REFERENCES APP_USER(id)
);

--pwd: test1234
insert into APP_USER(PASSWORD, USERNAME) values('$2a$10$bnC26zz//2cavYoSCrlHdecWF8tkGfPodlHcYwlACBBwJvcEf0p2G', 'mohit');
insert into APP_USER_ROLE(APP_USER_ID, ROLE) values(1, 'ADMIN');
