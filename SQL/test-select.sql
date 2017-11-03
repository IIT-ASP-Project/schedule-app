SELECT * FROM class;

SELECT * FROM student;

SELECT * FROM class_student;

SELECT * FROM assignment;

SELECT * FROM student_assignment;

SELECT * FROM teaching_assistant;

SELECT * FROM professor;

SELECT * FROM schedule;

/* Select all course for student with id=1 */
SELECT c.*
FROM class_student cs INNER JOIN class c ON(cs.class_id = c.id)
WHERE cs.student_id = 1;

/*Select all students in course with id=1 */
SELECT s.*
FROM class_student cs INNER JOIN student s ON(cs.student_id = s.id)
WHERE cs.class_id = 1;

/*Select names of students  in class with name='IIT-515'*/
SELECT s.*
FROM class c INNER JOIN class_student cs ON(c.id = cs.class_id)
INNER JOIN student s ON(cs.student_id = s.id)
WHERE c.name LIKE 'IIT-862';


/*Select all assignments for  class with name 'IIT-515'*/
SELECT a.*
FROM assignment a INNER JOIN class c ON(a.class_id = c.id)
WHERE c.name LIKE 'IIT-515';


/*Select average grade of a student with name 'Orik Hoxha' for a  class name 'IIT-515'*/
SELECT AVG(sa.grade)
FROM student s INNER JOIN student_assignment sa ON(s.id = sa.student_id)
INNER JOIN assignment a ON (sa.assignment_id = a.id)
INNER JOIN class c ON(a.class_id = c.id)
WHERE s.name = 'Orik Hoxha'
AND c.name = 'IIT-515';


/* Select all classes for professor with id = 1*/
SELECT c.*
FROM class c
WHERE c.professor_id  = 2;

/*SELECT all schedules for a class with id = 1*/
SELECT sch.*
FROM schedule sch
WHERE sch.class_id = 1;


/*Select all schedules for a professor with id = 2 */
SELECT sch.*
FROM schedule sch INNER JOIN class c ON(sch.class_id = c.id)
WHERE c.professor_id = 2;
