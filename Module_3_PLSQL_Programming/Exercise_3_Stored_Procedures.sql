CREATE OR REPLACE PROCEDURE update_employee_salary (
   p_emp_id IN NUMBER,
   p_increase_amount IN NUMBER
)
IS
BEGIN
   UPDATE employees
   SET salary = salary + p_increase_amount
   WHERE employee_id = p_emp_id;
   COMMIT;
   DBMS_OUTPUT.PUT_LINE('Salary updated successfully.');
END update_employee_salary;
/
