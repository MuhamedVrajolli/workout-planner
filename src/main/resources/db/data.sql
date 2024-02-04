-- User Table Insertions
INSERT INTO "user" (username, first_name, last_name, age, gender, weight, height)
VALUES ('john_doe', 'John', 'Doe', 28, true, 80, 180),
       ('jane_smith', 'Jane', 'Smith', 32, false, 65, 170);

-- Muscle Table Insertions
INSERT INTO muscle (name, description, latin_name, type)
VALUES ('Biceps', 'Front part of the upper arm', 'Musculus biceps brachii', 'PULL'),
       ('Triceps', 'Back part of the upper arm', 'Musculus triceps brachii', 'PUSH'),
       ('Front Shoulders', 'Front part of the shoulder', 'Musculus deltoideus anterior', 'PUSH'),
       ('Side Shoulders', 'Side part of the shoulder', 'Musculus deltoideus lateralis', 'PULL'),
       ('Rear Shoulders', 'Rear part of the shoulder', 'Musculus deltoideus posterior', 'PULL'),
       ('Back', 'Upper part of the back', 'Musculus latissimus dorsi', 'PULL'),
       ('Traps', 'Upper back and neck area', 'Musculus trapezius', 'PULL'),
       ('Lower Back', 'Lower part of the back', 'Musculus erector spinae', 'CORE'),
       ('Abs', 'Abdominal muscles', 'Musculus rectus abdominis', 'CORE'),
       ('Quadriceps', 'Front part of the thigh', 'Musculus quadriceps femoris', 'LEGS'),
       ('Hamstrings', 'Back part of the thigh', 'Musculus biceps femoris', 'LEGS'),
       ('Calves', 'Back part of the lower leg', 'Musculus gastrocnemius', 'LEGS'),
       ('Chest', 'Front part of the upper body', 'Musculus pectoralis major', 'PUSH');

-- Exercise Table Insertions
INSERT INTO exercise (name, description, file_url, type)
VALUES ('Shoulder Press', 'Exercise targeting the shoulder muscles', 'url_to_shoulder_press', 'WEIGHT'),
       ('Lateral Raises', 'Targets the lateral part of the shoulder', 'url_to_lateral_raises', 'WEIGHT'),
       ('Face Pulls', 'Strengthens the rear shoulders and upper back', 'url_to_face_pulls', 'WEIGHT'),
       ('Chin-ups', 'Upper body exercise targeting biceps and back', 'url_to_chin_ups', 'BODY_WEIGHT'),
       ('Push-ups', 'Exercise for chest and triceps', 'url_to_push_ups', 'BODY_WEIGHT'),
       ('Barbell Back Squat', 'Targets quadriceps and glutes', 'url_to_barbell_back_squat', 'WEIGHT'),
       ('Back Extensions', 'Strengthens the lower back muscles', 'url_to_back_extensions', 'BODY_WEIGHT'),
       ('Planks', 'Core strengthening exercise', 'url_to_planks', 'BODY_WEIGHT'),
       ('Leg Raises', 'Targets the abdominal muscles', 'url_to_leg_raises', 'BODY_WEIGHT'),
       ('Barbell Bench Press', 'Chest exercise focusing on pectoral muscles', 'url_to_barbell_bench_press', 'WEIGHT'),
       ('Incline Bench Press', 'Targets the upper chest and shoulders', 'url_to_incline_bench_press', 'WEIGHT'),
       ('Triceps Pushdown', 'Triceps exercise using a cable machine', 'url_to_triceps_pushdown', 'WEIGHT'),
       ('Dips', 'Targets triceps and chest', 'url_to_dips', 'BODY_WEIGHT'),
       ('Lat Pulldowns', 'Back exercise focusing on latissimus dorsi', 'url_to_lat_pulldowns', 'WEIGHT'),
       ('Pull-ups', 'Upper body exercise targeting the back and biceps', 'url_to_pull_ups', 'BODY_WEIGHT'),
       ('Cable Rows', 'Strengthens the back muscles', 'url_to_cable_rows', 'WEIGHT'),
       ('Cable Curls', 'Biceps exercise using a cable machine', 'url_to_cable_curls', 'WEIGHT'),
       ('Forward Lunges', 'Leg exercise targeting quadriceps and glutes', 'url_to_forward_lunges', 'BODY_WEIGHT'),
       ('Calf Raises', 'Targets the calf muscles', 'url_to_calf_raises', 'BODY_WEIGHT');

-- Exercise Muscle Table Insertions
INSERT INTO exercise_muscle (muscle_id, exercise_id, effect)
VALUES (3, 1, 'PRIMARY'),  -- Shoulder Press -> Front Shoulders
       (4, 2, 'PRIMARY'),  -- Lateral Raises -> Side Shoulders
       (5, 3, 'PRIMARY'),  -- Face Pulls -> Rear Shoulders
       (1, 4, 'PRIMARY'),  -- Chin-ups -> Biceps (Secondary: Back)
       (13, 5, 'PRIMARY'), -- Push-ups -> Chest (Secondary: Triceps)
       (10, 6, 'PRIMARY'), -- Barbell Back Squat -> Quadriceps (Secondary: Hamstrings)
       (8, 7, 'PRIMARY'),  -- Back Extensions -> Lower Back
       (9, 8, 'PRIMARY'),  -- Planks -> Abs
       (9, 9, 'PRIMARY'),  -- Leg Raises -> Abs
       (13, 10, 'PRIMARY'),-- Barbell Bench Press -> Chest
       (13, 11, 'PRIMARY'),-- Incline Bench Press -> Chest (Secondary: Front Shoulders)
       (2, 12, 'PRIMARY'), -- Triceps Pushdown -> Triceps
       (2, 13, 'PRIMARY'), -- Dips -> Triceps (Secondary: Chest)
       (6, 14, 'PRIMARY'), -- Lat Pulldowns -> Back
       (6, 15, 'PRIMARY'), -- Pull-ups -> Back (Secondary: Biceps)
       (6, 16, 'PRIMARY'), -- Cable Rows -> Back
       (1, 17, 'PRIMARY'), -- Cable Curls -> Biceps
       (10, 18, 'PRIMARY'),-- Forward Lunges -> Quadriceps (Secondary: Glutes)
       (12, 19, 'PRIMARY'); -- Calf Raises -> Calves

-- Workout Plan Table Insertions
INSERT INTO workout_plan (name, description, author_id, category, published)
VALUES ('PPL', 'Push, Pull, Legs split workout plan', 1, 'INTERMEDIATE', true);

-- Workout Day Table Insertions
INSERT INTO workout_day (day_name, day_of_week, plan_id)
VALUES ('Push', 1, 1), -- Monday
       ('Pull', 3, 1), -- Wednesday
       ('Legs', 5, 1); -- Friday

-- Day Exercise Table Insertions
-- Push Day Exercises (Monday)
INSERT INTO day_exercise (workout_day_id, exercise_id, sets, reps, until_failure, minutes)
VALUES (1, 1, 4, ARRAY[8, 8, 8, 8], false, 0),  -- Shoulder Press
       (1, 10, 3, ARRAY[10, 10, 10], false, 0), -- Barbell Bench Press
       (1, 11, 3, ARRAY[10, 10, 10], false, 0), -- Incline Bench Press
       (1, 12, 3, ARRAY[12, 12, 12], false, 0); -- Triceps Pushdown

-- Pull Day Exercises (Wednesday)
INSERT INTO day_exercise (workout_day_id, exercise_id, sets, reps, until_failure, minutes)
VALUES (2, 4, 4, ARRAY[6, 6, 6, 6], false, 0),  -- Chin-ups
       (2, 14, 3, ARRAY[10, 10, 10], false, 0), -- Lat Pulldowns
       (2, 15, 3, ARRAY[8, 8, 8], false, 0),    -- Pull-ups
       (2, 16, 3, ARRAY[12, 12, 12], false, 0); -- Cable Rows

-- Legs Day Exercises (Friday)
INSERT INTO day_exercise (workout_day_id, exercise_id, sets, reps, until_failure, minutes)
VALUES (3, 6, 4, ARRAY[8, 8, 8, 8], false, 0),  -- Barbell Back Squat
       (3, 18, 3, ARRAY[10, 10, 10], false, 0), -- Forward Lunges
       (3, 19, 3, ARRAY[15, 15, 15], false, 0), -- Calf Raises
       (3, 7, 3, ARRAY[12, 12, 12], false, 0); -- Back Extensions

-- Workout Plan Insertion
INSERT INTO workout_plan (name, description, author_id, category, published)
VALUES ('Full Body', 'A comprehensive workout plan targeting all major muscle groups in each session', 2, 'BEGINNER',
        true);

-- Workout Day Insertions for Full Body Plan
INSERT INTO workout_day (day_name, day_of_week, plan_id)
VALUES ('Full Body 1', 1, 2), -- Monday
       ('Full Body 2', 3, 2), -- Wednesday
       ('Full Body 3', 5, 2); -- Friday

-- Day Exercise Insertions for Full Body Workouts
-- Full Body 1 Exercises (Monday)
INSERT INTO day_exercise (workout_day_id, exercise_id, sets, reps, until_failure, minutes)
VALUES (4, 10, 3, ARRAY[10, 10, 10], false, 0), -- Barbell Bench Press
       (4, 6, 3, ARRAY[8, 8, 8], false, 0),     -- Barbell Back Squat
       (4, 14, 3, ARRAY[10, 10, 10], false, 0), -- Lat Pulldowns
       (4, 8, 2, ARRAY[60, 60], true, 1); -- Planks

-- Full Body 2 Exercises (Wednesday)
INSERT INTO day_exercise (workout_day_id, exercise_id, sets, reps, until_failure, minutes)
VALUES (5, 11, 3, ARRAY[10, 10, 10], false, 0), -- Incline Bench Press
       (5, 18, 3, ARRAY[10, 10, 10], false, 0), -- Forward Lunges
       (5, 15, 3, ARRAY[8, 8, 8], false, 0),    -- Pull-ups
       (5, 9, 3, ARRAY[15, 15, 15], false, 0); -- Leg Raises

-- Full Body 3 Exercises (Friday)
INSERT INTO day_exercise (workout_day_id, exercise_id, sets, reps, until_failure, minutes)
VALUES (6, 12, 3, ARRAY[12, 12, 12], false, 0), -- Triceps Pushdown
       (6, 19, 3, ARRAY[15, 15, 15], false, 0), -- Calf Raises
       (6, 4, 3, ARRAY[6, 6, 6], false, 0),     -- Chin-ups
       (6, 7, 3, ARRAY[12, 12, 12], false, 0); -- Back Extensions

-- Workout Plan Insertion
INSERT INTO workout_plan (name, description, author_id, category, published)
VALUES ('Upper-Lower Split', 'An upper-lower split workout plan for balanced muscle growth', 2, 'INTERMEDIATE', true);

-- Workout Day Insertions for Upper-Lower Split
INSERT INTO workout_day (day_name, day_of_week, plan_id)
VALUES ('Upper Body', 1, 3), -- Monday
       ('Lower Body', 2, 3), -- Tuesday
       ('Upper Body', 4, 3), -- Thursday
       ('Lower Body', 5, 3); -- Friday

-- Day Exercise Insertions for Upper-Lower Split Workouts
-- Upper Body Exercises (Monday & Thursday)
INSERT INTO day_exercise (workout_day_id, exercise_id, sets, reps, until_failure, minutes)
VALUES (7, 10, 3, ARRAY[10, 10, 10], false, 0), -- Barbell Bench Press
       (7, 14, 3, ARRAY[10, 10, 10], false, 0), -- Lat Pulldowns
       (7, 2, 3, ARRAY[12, 12, 12], false, 0),  -- Lateral Raises
       (7, 13, 3, ARRAY[10, 10, 10], false, 0), -- Dips
       (8, 10, 3, ARRAY[10, 10, 10], false, 0), -- Barbell Bench Press
       (8, 14, 3, ARRAY[10, 10, 10], false, 0), -- Lat Pulldowns
       (8, 2, 3, ARRAY[12, 12, 12], false, 0),  -- Lateral Raises
       (8, 13, 3, ARRAY[10, 10, 10], false, 0); -- Dips
-- Lower Body Exercises (Tuesday & Friday)
INSERT INTO day_exercise (workout_day_id, exercise_id, sets, reps, until_failure, minutes)
VALUES (9, 6, 4, ARRAY[8, 8, 8, 8], false, 0),   -- Barbell Back Squat
       (9, 18, 3, ARRAY[10, 10, 10], false, 0),  -- Forward Lunges
       (9, 19, 3, ARRAY[15, 15, 15], false, 0),  -- Calf Raises
       (9, 7, 3, ARRAY[12, 12, 12], false, 0),   -- Back Extensions
       (10, 6, 4, ARRAY[8, 8, 8, 8], false, 0),  -- Barbell Back Squat
       (10, 18, 3, ARRAY[10, 10, 10], false, 0), -- Forward Lunges
       (10, 19, 3, ARRAY[15, 15, 15], false, 0), -- Calf Raises
       (10, 7, 3, ARRAY[12, 12, 12], false, 0); -- Back Extensions

-- Tag Insertion
INSERT INTO tag (name)
VALUES ('full body'),
       ('ppl'),
       ('weightlifting'),
       ('bulking'),
       ('cutting');

-- Workout Plan Tag Insertion
INSERT INTO workout_plan_tag (workout_plan_id, tag_id)
VALUES (1, 2),
       (1, 3),
       (1, 4),
       (2, 1),
       (2, 3),
       (2, 5),
       (3, 3);
