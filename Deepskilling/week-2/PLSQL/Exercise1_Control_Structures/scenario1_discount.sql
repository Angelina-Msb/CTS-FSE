SET SERVEROUTPUT ON;

DECLARE
    -- Cursor to loop through loans alongside the customer's date of birth
    CURSOR c_customer_loans IS
        SELECT l.LoanID, l.InterestRate, c.DOB 
        FROM Loans l 
        JOIN Customers c ON l.CustomerID = c.CustomerID;
        
    v_age NUMBER;
BEGIN
    FOR r_loan IN c_customer_loans LOOP
        -- Calculate age based on Date of Birth
        v_age := FLOOR(MONTHS_BETWEEN(SYSDATE, r_loan.DOB) / 12);
        
        -- Control Structure: If age is over 60, apply a 1% discount (deduct 0.01)
        IF v_age > 60 THEN
            UPDATE Loans 
            SET InterestRate = InterestRate - 0.01 
            WHERE LoanID = r_loan.LoanID;
            
            DBMS_OUTPUT.PUT_LINE('Loan ID ' || r_loan.LoanID || ': Applied 1% senior discount (Age: ' || v_age || ').');
        END IF;
    END LOOP;
    
    COMMIT;
END;
/