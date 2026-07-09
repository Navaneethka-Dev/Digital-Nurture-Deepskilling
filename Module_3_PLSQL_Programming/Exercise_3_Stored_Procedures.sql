-- Exercise 3: Stored Procedures with validation and exception handling
CREATE OR REPLACE PROCEDURE update_employee_salary (
   p_employee_id       IN employees.employee_id%TYPE,
   p_increment_amount  IN NUMBER
)
IS
   v_current_salary employees.salary%TYPE;
BEGIN
   -- Validate the increment amount
   IF p_increment_amount <= 0 THEN
       DBMS_OUTPUT.PUT_LINE('Error: Increment amount must be greater than zero.');
       RETURN;
   END IF;

   -- Attempt the update
   UPDATE employees
   SET salary = salary + p_increment_amount
   WHERE employee_id = p_employee_id
   RETURNING salary INTO v_current_salary;
   
   -- Check if the employee existed
   IF SQL%ROWCOUNT = 0 THEN
       DBMS_OUTPUT.PUT_LINE('Error: No employee found with ID ' || p_employee_id);
   ELSE
       COMMIT;
       DBMS_OUTPUT.PUT_LINE('Success: Salary for employee ' || p_employee_id || 
                            ' updated. New Salary: ' || v_current_salary);
   END IF;

EXCEPTION
   WHEN OTHERS THEN
      ROLLBACK;
      DBMS_OUTPUT.PUT_LINE('Database error occurred while updating salary: ' || SQLERRM);
END update_employee_salary;
/
