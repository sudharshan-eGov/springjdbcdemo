--create table

CREATE TABLE employees (
   id BIGSERIAL NOT NULL PRIMARY KEY,
   username VARCHAR(200) NOT NULL,
   email VARCHAR(200) NOT NULL,
   phonenumber VARCHAR(20) NOT NULL,
   age integer NOT NULL,
   department_id int NOT NULL,
   CONSTRAINT employees_department_id FOREIGN KEY (department_id) REFERENCES department (id)


)

--insert data

INSERT INTO employees(username, email, phonenumber, age) VALUES(?, ?, ?, ?)


--update


UPDATE employees set username=?, email=?, phonenumber=?, age=? WHERE id=?

--delete
DELETE FROM employees WHERE id=?

--get data

SELECT * from employees

--get data by id

SELECT * FROM employees WHERE id =?

