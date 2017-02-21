alter table employee change column first_name emp_name varchar(50);
create table payroll (emp_id INT NOT NULL AUTO_INCREMENT, emp_name VARCHAR(120), PRIMARY KEY ( emp_id ));