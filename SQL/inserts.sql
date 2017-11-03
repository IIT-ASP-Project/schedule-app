INSERT INTO professor(name,email) VALUES('Omar Aldawud','aldaoma@iit.edu');



/*We are currently adding only one professor to a class... feel free to add professors to other classes */
INSERT INTO class(name,syllabus,professor_id,todo,textbook) VALUES('IIT-515','/syllabus/path',1,'todo..','/textbook/path');

/*These 3 classes do not currently have a professor assigned to them */
INSERT INTO class(name,syllabus) VALUES('IIT-855','/syllabu/path');
INSERT INTO class(name,syllabus) VALUES('IIT-862','/syllabus/path');
INSERT INTO class(name,syllabus) VALUES('IIT-865','/syllabus/path');


INSERT INTO student(name,username,email) VALUES('Orik Hoxha','Orik','ohoxha@hawk.iit.edu');
INSERT INTO student(name,username,email) VALUES('Randy Zezelnak','Randy','rzezelnak@hawk.iit.edu');
INSERT INTO student(name,username,email) VALUES('Bob Marat','Marat','bmarat@hawk.iit.edu');



INSERT INTO class_student(class_id,student_id) VALUES(1,1);
INSERT INTO class_student(class_id,student_id) VALUES(2,1);
INSERT INTO class_student(class_id,student_id) VALUES(4,1);

INSERT INTO class_student(class_id,student_id) VALUES(1,2);
INSERT INTO class_student(class_id,student_id) VALUES(3,2);
INSERT INTO class_student(class_id,student_id) VALUES(4,2);


INSERT INTO class_student(class_id,student_id) VALUES(2,3);
INSERT INTO class_student(class_id,student_id) VALUES(3,3);
INSERT INTO class_student(class_id,student_id) VALUES(4,3);


INSERT INTO assignment(title,description,due_date,file_path,class_id)
VALUES('Week 7 - Assignment','Create tables and represent JSON', STR_TO_DATE('09-Oct-2017', '%d-%M-%Y'),'/assignment/path',1);


INSERT INTO assignment(title,description,due_date,file_path,class_id)
VALUES('Week 8 - Assignment','ORM - Create the ORM for the tables', STR_TO_DATE('25-Oct-2017', '%d-%M-%Y'),'/assignment/path',1);

INSERT INTO assignment(title,description,due_date,file_path,class_id)
VALUES('Week 1 - Assignment','Javscript - Create the DOM objects', STR_TO_DATE('25-Oct-2017', '%d-%M-%Y'),'/assignment/path',4);


INSERT INTO student_assignment(student_id,assignment_id,grade) VALUES(1,1,100);
INSERT INTO student_assignment(student_id,assignment_id,grade) VALUES(1,2,90);
INSERT INTO student_assignment(student_id,assignment_id,grade) VALUES(1,3,90);



INSERT INTO student_assignment(student_id,assignment_id,grade) VALUES(2,1,100);
INSERT INTO student_assignment(student_id,assignment_id,grade) VALUES(2,2,100);
INSERT INTO student_assignment(student_id,assignment_id,grade) VALUES(2,3,100);

INSERT INTO student_assignment(student_id,assignment_id,grade) VALUES(3,1,100);
INSERT INTO student_assignment(student_id,assignment_id,grade) VALUES(3,2,100);
INSERT INTO student_assignment(student_id,assignment_id,grade) VALUES(3,3,100);


INSERT INTO teaching_assistant(name,email,office_hour,class_id) VALUES('John Mcgray','jmg@iit.edu','14:30-20:00',1);

INSERT INTO schedule(type,date_time,location,class_id) VALUES('Lesson',STR_TO_DATE('10-20-2017 19:00','%m-%d-%Y %H:%i'),'Main Campus - SB',1);