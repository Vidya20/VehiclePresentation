alter table employee change column emp_name first_name varchar(50);
create table payroll (emp_id INT NOT NULL AUTO_INCREMENT, emp_name VARCHAR(100), PRIMARY KEY ( emp_id ));