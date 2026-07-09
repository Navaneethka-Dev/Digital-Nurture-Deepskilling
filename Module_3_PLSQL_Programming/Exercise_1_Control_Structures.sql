SET SERVEROUTPUT ON;

DECLARE
   v_test_number NUMBER := 15;
   v_iteration_limit NUMBER := 5;
BEGIN
   DBMS_OUTPUT.PUT_LINE('--- Starting Control Structures Test ---');
   
   IF v_test_number > 10 THEN
      DBMS_OUTPUT.PUT_LINE('Result: The provided number (' || v_test_number || ') is strictly greater than 10.');
   ELSIF v_test_number = 10 THEN
      DBMS_OUTPUT.PUT_LINE('Result: The provided number is exactly 10.');
   ELSE
      DBMS_OUTPUT.PUT_LINE('Result: The provided number is less than 10.');
   END IF;
   
   DBMS_OUTPUT.PUT_LINE('--- Commencing Loop Execution ---');
   
   FOR i IN 1..v_iteration_limit LOOP
      DBMS_OUTPUT.PUT_LINE('-> Executing iteration pass: ' || i);
   END LOOP;
   
   DBMS_OUTPUT.PUT_LINE('--- Execution Completed ---');
EXCEPTION
   WHEN OTHERS THEN
      DBMS_OUTPUT.PUT_LINE('An unexpected error occurred: ' || SQLERRM);
END;
/
