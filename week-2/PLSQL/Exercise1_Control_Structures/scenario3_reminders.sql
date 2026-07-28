SET SERVEROUTPUT ON;

DECLARE
    -- Cursor to fetch loans due within the next 30 days
    CURSOR c_due_loans IS
        SELECT LoanID, CustomerID, EndDate 
        FROM Loans 
        WHERE EndDate BETWEEN SYSDATE AND SYSDATE + 30;
BEGIN
    DBMS_OUTPUT.PUT_LINE('--- Upcoming Loan Expiry Reminders ---');
    
    FOR r_loan IN c_due_loans LOOP
        -- Print a reminder message for each matching customer row
        DBMS_OUTPUT.PUT_LINE('Reminder: Loan ID ' || r_loan.LoanID || 
                             ' for Customer ID ' || r_loan.CustomerID || 
                             ' is due on ' || TO_CHAR(r_loan.EndDate, 'YYYY-MM-DD') || '.');
    END LOOP;
END;
/