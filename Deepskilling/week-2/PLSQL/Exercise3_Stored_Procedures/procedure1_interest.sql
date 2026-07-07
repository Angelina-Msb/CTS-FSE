CREATE OR REPLACE PROCEDURE ProcessMonthlyInterest AS
BEGIN
    -- 1. Update accounts where the type is exactly 'Savings'
    UPDATE Accounts 
    SET Balance = Balance * 1.01, -- Multiplies by 1.01 to add exactly 1% interest
        LastModified = SYSDATE
    WHERE AccountType = 'Savings';
    
    -- 2. Print a success confirmation notice
    DBMS_OUTPUT.PUT_LINE('Monthly interest of 1% successfully processed for all Savings accounts.');
    
    -- 3. Save the changes permanently in the database
    COMMIT;
EXCEPTION
    -- If any unexpected error occurs, cancel the transaction safely
    WHEN OTHERS THEN
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE('Error processing monthly interest: ' || SQLERRM);
END;
/