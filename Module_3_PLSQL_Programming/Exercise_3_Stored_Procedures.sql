-- Scenario 1: ProcessMonthlyInterest
CREATE OR REPLACE PROCEDURE ProcessMonthlyInterest IS
BEGIN
    UPDATE savings_accounts
    SET balance = balance + (balance * 0.01);
    DBMS_OUTPUT.PUT_LINE('Monthly interest of 1% applied to all savings accounts.');
    COMMIT;
END ProcessMonthlyInterest;
/

-- Scenario 2: UpdateEmployeeBonus
CREATE OR REPLACE PROCEDURE UpdateEmployeeBonus (
    p_department_id IN employees.department_id%TYPE,
    p_bonus_percentage IN NUMBER
) IS
BEGIN
    UPDATE employees
    SET salary = salary + (salary * (p_bonus_percentage / 100))
    WHERE department_id = p_department_id;
    DBMS_OUTPUT.PUT_LINE('Bonus of ' || p_bonus_percentage || '% applied to department ' || p_department_id);
    COMMIT;
END UpdateEmployeeBonus;
/

-- Scenario 3: TransferFunds
CREATE OR REPLACE PROCEDURE TransferFunds (
    p_from_account IN accounts.account_id%TYPE,
    p_to_account IN accounts.account_id%TYPE,
    p_amount IN NUMBER
) IS
    v_balance accounts.balance%TYPE;
BEGIN
    -- Check balance
    SELECT balance INTO v_balance FROM accounts WHERE account_id = p_from_account FOR UPDATE;
    
    IF v_balance >= p_amount THEN
        UPDATE accounts SET balance = balance - p_amount WHERE account_id = p_from_account;
        UPDATE accounts SET balance = balance + p_amount WHERE account_id = p_to_account;
        DBMS_OUTPUT.PUT_LINE('Successfully transferred $' || p_amount || ' from Account ' || p_from_account || ' to Account ' || p_to_account);
        COMMIT;
    ELSE
        DBMS_OUTPUT.PUT_LINE('Error: Insufficient balance in Account ' || p_from_account);
        ROLLBACK;
    END IF;
EXCEPTION
    WHEN NO_DATA_FOUND THEN
        DBMS_OUTPUT.PUT_LINE('Error: One or both accounts do not exist.');
        ROLLBACK;
    WHEN OTHERS THEN
        DBMS_OUTPUT.PUT_LINE('Unexpected Error: ' || SQLERRM);
        ROLLBACK;
END TransferFunds;
/
