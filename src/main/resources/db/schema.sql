CREATE TABLE IF NOT EXISTS "user" (
                        id serial PRIMARY KEY,
                        username text UNIQUE NOT NULL,
                        first_name text NOT NULL,
                        last_name text NOT NULL,
                        age int,
                        gender boolean,
                        weight int,
                        height int,
                        created_date timestamp DEFAULT current_timestamp,
                        updated_date timestamp,
                        deleted boolean DEFAULT false
);

CREATE TABLE IF NOT EXISTS muscle (
                        id serial PRIMARY KEY,
                        name text NOT NULL,
                        description text NOT NULL,
                        latin_name text,
                        type text CHECK (type IN ('PUSH', 'PULL', 'CORE', 'LEGS')) NOT NULL,
                        created_date timestamp DEFAULT current_timestamp,
                        updated_date timestamp,
                        deleted boolean DEFAULT false
);

CREATE TABLE IF NOT EXISTS exercise (
                          id serial PRIMARY KEY,
                          name text NOT NULL,
                          description text NOT NULL,
                          file_url text,
                          type text CHECK (type IN ('WEIGHT', 'BODY_WEIGHT', 'CARDIO')) NOT NULL,
                          created_date timestamp DEFAULT current_timestamp,
                          updated_date timestamp,
                          deleted boolean DEFAULT false
);

CREATE TABLE IF NOT EXISTS workout_plan (
                              id serial PRIMARY KEY,
                              name text NOT NULL,
                              description text,
                              author_id int REFERENCES "user"(id) NOT NULL,
                              category text CHECK (category IN ('BEGINNER', 'INTERMEDIATE', 'ADVANCED')),
                              published boolean DEFAULT false,
                              created_date timestamp DEFAULT current_timestamp,
                              updated_date timestamp,
                              deleted boolean DEFAULT false
);

CREATE TABLE IF NOT EXISTS user_bookmarked_workout_plans (
                     id serial PRIMARY KEY,
                     user_id int REFERENCES "user"(id) NOT NULL,
                     workout_plan_id int REFERENCES workout_plan(id) NOT NULL,
                     created_date timestamp DEFAULT current_timestamp,
                     updated_date timestamp,
                     deleted boolean DEFAULT false
);

CREATE TABLE IF NOT EXISTS tag (
                     id serial PRIMARY KEY,
                     name text NOT NULL,
                     created_date timestamp DEFAULT current_timestamp,
                     updated_date timestamp,
                     deleted boolean DEFAULT false
);

CREATE TABLE IF NOT EXISTS workout_plan_tag (
                                  id serial PRIMARY KEY,
                                  tag_id int REFERENCES tag(id) NOT NULL,
                                  workout_plan_id int REFERENCES workout_plan(id) NOT NULL,
                                  created_date timestamp DEFAULT current_timestamp,
                                  updated_date timestamp,
                                  deleted boolean DEFAULT false
);

CREATE TABLE IF NOT EXISTS exercise_muscle (
                                 id serial PRIMARY KEY,
                                 muscle_id int REFERENCES muscle(id) NOT NULL,
                                 exercise_id int REFERENCES exercise(id) NOT NULL,
                                 effect text CHECK (effect IN ('PRIMARY', 'SECONDARY')) NOT NULL,
                                 created_date timestamp DEFAULT current_timestamp,
                                 updated_date timestamp,
                                 deleted boolean DEFAULT false
);

CREATE TABLE IF NOT EXISTS workout_day (
                             id serial PRIMARY KEY,
                             day_name text NOT NULL,
                             day_of_week int CHECK (day_of_week IN (1, 2, 3, 4, 5, 6, 7)) NOT NULL,
                             plan_id int REFERENCES workout_plan(id) NOT NULL,
                             created_date timestamp DEFAULT current_timestamp,
                             updated_date timestamp,
                             deleted boolean DEFAULT false
);

CREATE TABLE IF NOT EXISTS day_exercise (
                              id serial PRIMARY KEY,
                              workout_day_id int REFERENCES workout_day(id) NOT NULL,
                              exercise_id int REFERENCES exercise(id) NOT NULL,
                              sets int,
                              reps integer[],
                              until_failure boolean,
                              minutes int,
                              created_date timestamp DEFAULT current_timestamp,
                              updated_date timestamp,
                              deleted boolean DEFAULT false
);

CREATE TABLE IF NOT EXISTS progress_tracker (
                                  id serial PRIMARY KEY,
                                  user_id int REFERENCES "user"(id) NOT NULL,
                                  exercise_id int REFERENCES exercise(id) NOT NULL,
                                  sets int,
                                  reps_and_weight integer[],
                                  until_failure boolean,
                                  minutes int,
                                  body_weight int,
                                  created_date timestamp DEFAULT current_timestamp,
                                  updated_date timestamp,
                                  deleted boolean DEFAULT false
);


CREATE TABLE IF NOT EXISTS overload_goal (
                               id serial PRIMARY KEY,
                               user_id int REFERENCES "user"(id),
                               exercise_id int REFERENCES exercise(id),
                               max_weight int,
                               max_sets int,
                               max_reps int,
                               max_minutes int,
                               due_date date NOT NULL,
                               achieved boolean,
                               created_date timestamp DEFAULT current_timestamp,
                               updated_date timestamp,
                               deleted boolean DEFAULT false
);
