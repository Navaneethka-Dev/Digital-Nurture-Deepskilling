-- Scenario 1: Apply discount to loan interest rates for customers above 60 years old
DECLARE
    CURSOR c_customers IS SELECT customer_id, age, loan_interest_rate FROM customers;
BEGIN
    FOR rec IN c_customers LOOP
        IF rec.age > 60 THEN
            UPDATE customers
            SET loan_interest_rate = loan_interest_rate - 1
            WHERE customer_id = rec.customer_id;
            DBMS_OUTPUT.PUT_LINE('Applied 1% discount for Customer ID: ' || rec.customer_id);
        END IF;
    END LOOP;
    COMMIT;
END;
/

-- Scenario 2: Promote customer to VIP status based on balance over $10,000
DECLARE
    CURSOR c_customers IS SELECT customer_id, balance FROM customers;
BEGIN
    FOR rec IN c_customers LOOP
        IF rec.balance > 10000 THEN
            UPDATE customers
            SET IsVIP = 'TRUE'
            WHERE customer_id = rec.customer_id;
            DBMS_OUTPUT.PUT_LINE('Promoted Customer ID: ' || rec.customer_id || ' to VIP.');
        END IF;
    END LOOP;
    COMMIT;
END;
/

-- Scenario 3: Send reminders to customers whose loans are due within the next 30 days
DECLARE
    CURSOR c_loans IS 
        SELECT customer_id, due_date 
        FROM loans 
        WHERE due_date BETWEEN SYSDATE AND SYSDATE + 30;
BEGIN
    FOR rec IN c_loans LOOP
        DBMS_OUTPUT.PUT_LINE('Reminder: Customer ID ' || rec.customer_id || ', your loan is due on ' || TO_CHAR(rec.due_date, 'YYYY-MM-DD'));
    END LOOP;
END;
/
