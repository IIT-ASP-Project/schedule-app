CREATE TABLE professor(
	id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(30),
    email VARCHAR(50)
);

CREATE TABLE class(
	id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(20),
    syllabus VARCHAR(255),
    professor_id INT,
    todo VARCHAR(255),
    textbook VARCHAR(255),
    
    FOREIGN KEY(professor_id)
    REFERENCES professor(id)
);

CREATE TABLE student(
	id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(30),
    username VARCHAR(30),
    email VARCHAR(30)
);

CREATE TABLE class_student(
	id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    class_id INT NOT NULL,
    student_id INT NOT NULL,
    
    FOREIGN KEY(class_id)
    REFERENCES class(id)
    ON DELETE CASCADE ON UPDATE CASCADE,
    
    FOREIGN KEY(student_id)
    REFERENCES student(id)
    ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE assignment(
	id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
	title VARCHAR(255),
    description VARCHAR(500),
    due_date DATE,
	file_path VARCHAR(255),
    class_id INT,
    
    FOREIGN KEY(class_id)
    REFERENCES class(id)
    ON DELETE CASCADE ON UPDATE CASCADE

);


CREATE TABLE student_assignment(
	id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
	student_id INT,
    assignment_id INT,
    grade INT,
    
    FOREIGN KEY(student_id)
    REFERENCES student(id)
    ON DELETE CASCADE ON UPDATE CASCADE,
    
    FOREIGN KEY(assignment_id)
    REFERENCES assignment(id)
    ON DELETE CASCADE ON UPDATE CASCADE
    
);

CREATE TABLE teaching_assistant(
	id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(30),
    email VARCHAR(40),
    office_hour VARCHAR(20),
    class_id INT UNIQUE,
    
    FOREIGN KEY(class_id) REFERENCES class(id)
    ON DELETE CASCADE ON UPDATE CASCADE
);



CREATE TABLE `schedule`(
	id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    type VARCHAR(30),
    date_time DATETIME,
    location VARCHAR(255),
    class_id INT,
    
    FOREIGN KEY(class_id)
	REFERENCES class(id)
);