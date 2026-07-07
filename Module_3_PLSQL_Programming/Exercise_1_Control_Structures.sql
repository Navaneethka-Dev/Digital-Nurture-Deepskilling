DECLARE
   num_val NUMBER := 10;
BEGIN
   IF num_val > 5 THEN
      DBMS_OUTPUT.PUT_LINE('Number is greater than 5');
   ELSE
      DBMS_OUTPUT.PUT_LINE('Number is 5 or less');
   END IF;
   
   FOR i IN 1..5 LOOP
      DBMS_OUTPUT.PUT_LINE('Iteration: ' || i);
   END LOOP;
END;
/
