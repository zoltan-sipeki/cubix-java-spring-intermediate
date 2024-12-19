BEGIN;

CREATE TABLE  course (
    id INT NOT NULL,
    name VARCHAR(255) NOT NULL,

    CONSTRAINT pk_course PRIMARY KEY(id)
);

CREATE SEQUENCE course_seq INCREMENT BY 50 START WITH 1;

--

CREATE TABLE course_student (
    id INT NOT NULL,
    student_id INT NOT NULL,
    course_id INT NOT NULL,

    CONSTRAINT pk_course_student PRIMARY KEY(id),
    CONSTRAINT fk_course_student_student_id FOREIGN KEY(student_id) REFERENCES student (id),
    CONSTRAINT fk_course_student_course_id FOREIGN KEY(course_id) REFERENCES course (id)
);

CREATE SEQUENCE course_student_seq INCREMENT BY 50 START WITH 1;

--

CREATE TABLE course_teacher (
    id INT NOT NULL,
    teacher_id INT NOT NULL,
    course_id INT NOT NULL,

    CONSTRAINT pk_course_teacher PRIMARY KEY(id),
    CONSTRAINT fk_course_teacher_student_id FOREIGN KEY(teacher_id) REFERENCES teacher (id),
    CONSTRAINT fk_course_teacher_course_id FOREIGN KEY(course_id) REFERENCES course (id)
);


CREATE SEQUENCE course_teacher_seq INCREMENT BY 50 START WITH 1;


COMMIT;
