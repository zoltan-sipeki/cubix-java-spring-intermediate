BEGIN;

CREATE TABLE student (
    id INT NOT NULL,
    name VARCHAR(255) NOT NULL,
    birthdate DATE NOT NULL,
    semester INT NOT NULL,

    CONSTRAINT pk_student PRIMARY KEY (id)
);

CREATE SEQUENCE student_seq INCREMENT BY 50 START WITH 1;

COMMIT;