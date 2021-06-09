BEGIN;

DROP TABLE IF EXISTS student CASCADE;
CREATE TABLE student (id bigserial PRIMARY KEY, name VARCHAR(255), mark int);
INSERT INTO student (name, mark) VALUES
('Student 1', 10),
('Student 2', 20),
('Student 3', 100),
('Student 4', 50),
('Student 5', 500);

COMMIT;