
INSERT INTO Student (name, phone, address) VALUES('John', '123456', 'Street 123');
INSERT INTO Department(name) VALUES ("Maths");
INSERT INTO Teacher(name, department_id, phone_number, email) VALUES('Marc', '01', '123', 'marc@marc.com');
INSERT INTO Building(name, location, creation_date) VALUES('Maths', 'North',STR_TO_DATE('17,12,2015','%d,%m,%Y')); 
INSERT INTO Room(number, capacity, building_id) VALUES(6, 50, 01);
INSERT INTO Subject(name, hours, credits) VALUES('Physics', '70', '5');

UPDATE Exam SET mark='A' WHERE id=5;
UPDATE Room SET capacity=70 WHERE building_id=01;
UPDATE Subject SET name='History' WHERE id=01;
UPDATE Teacher SET email="marc@education.account.com" WHERE id=01;
UPDATE Student SET phone='+542494636177' WHERE id=01;

DELETE FROM Student WHERE id=01;
DELETE FROM Teacher WHERE id=01;
DELETE FROM Building WHERE id=01;
DELETE FROM Room WHERE id=01;
DELETE FROM Subject WHERE id=01;


SELECT *
FROM Reservation r 
LEFT JOIN Book b ON (r.book_id=b.id)
LEFT JOIN Library l ON (b.library_id=l.id)
LEFT JOIN Student st ON(st.id=r.student_id)
LEFT JOIN Study s ON (s.student_id=st.id)
LEFT JOIN Exam e ON(s.id=e.study_id)
LEFT JOIN Teach t ON (s.teach_id=t.id)
LEFT JOIN Teacher te ON (t.teacher_id=te.id)
LEFT JOIN Subject su ON(su.id=t.subject_id)
LEFT JOIN ReservationRoom rr ON (rr.teacher_id=te.id)
LEFT JOIN Room ro ON (rr.room_id=ro.id)
LEFT JOIN Building bu ON(bu.id= ro.building_id)
LEFT JOIN Department d ON(d.id=te.department_id)

--teachers that teach more than 4 subjects.
SELECT t.teacher_id, COUNT(t.subject_id) as 'Number of Subjects'
FROM Teach t
INNER JOIN Subject s ON(t.subject_id=s.id)
GROUP BY t.teacher_id
HAVING COUNT(t.subject_id)>4;

--all buildings with more than 5 rooms 
SELECT b.id, COUNT(r.id) as 'Number of Rooms'
FROM Building b 
INNER JOIN Room r ON (r.building_id=b.id)
GROUP BY b.id
HAVING COUNT(r.id)>5;

--all students that have been studied more than 3 subjects.
SELECT student_id, COUNT (*) as 'Number of subjects'
FROM Study 
GROUP BY student_id
HAVING COUNT(teach_id)>3;

--books that have been reservated more than 2 times
SELECT book_id, COUNT(id) as 'Number of reservations'
FROM Reservation
GROUP BY book_id
HAVING COUNT(id)>2;


-- departments with more than 10 teachers
SELECT d.id, COUNT(t.id) as 'Number of teachers'
FROM Department d 
INNER JOIN Teacher t ON (d.id = t.department_id)
GROUP BY d.id
HAVING COUNT(t.id)>10

--Rooms with less than 5 reservations 
SELECT room_id,COUNT(id) as 'Reservations'
FROM ReservationRoom 
GROUP BY room_id
HAVING COUNT(id)<5;

--libraries with less than 356 books
SELECT library_id, COUNT(id) as 'Number of books'
FROM Book
GROUP BY library_id
HAVING COUNT(id)<356;



--3 with group by 
SELECT Building, COUNT(id) AS 'Amount of Rooms'
FROM Room
GROUP BY building_id

SELECT d.id, COUNT(t.id)
FROM Department d 
INNER JOIN Teacher t ON (d.id = t.department_id)
GROUP BY d.id;

SELECT t.teacher_id, COUNT(t.subject_id)
FROM Teach t
INNER JOIN Subject s ON(t.subject_id=s.id)
GROUP BY t.teacher_id

--3 without group by
SELECT e.study_id, AVG(m.number_mark) AS "Average"
FROM Exam e 
INNER JOIN Mark m
ON (m.id=e.mark_id);

SELECT d.id, COUNT(t.id)
FROM Department d 
INNER JOIN Teacher t ON (d.id = t.department_id);

SELECT t.teacher_id, COUNT(t.subject_id)
FROM Teach t
INNER JOIN Subject s ON(t.subject_id=s.id)