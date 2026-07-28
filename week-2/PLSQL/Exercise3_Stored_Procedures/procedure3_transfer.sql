CREATE OR REPLACE PROCEDURE TransferFunds (
    p_source_account IN NUMBER,
    p_dest_account   IN NUMBER,
    p_amount         IN NUMBER
) AS
    v_source_balance NUMBER;
BEGIN
    -- 1. Fetch the current balance of the sender's account
    SELECT Balance INTO v_source_balance 
    FROM Accounts 
    WHERE AccountID = p_source_account;
    
    -- 2. Control Structure: Verify if the sender has enough money
    IF v_source_balance < p_amount THEN
        DBMS_OUTPUT.PUT_LINE('Transaction Failed: Insufficient funds in Source Account ' || p_source_account);
    ELSE
        -- Deduct the amount from the sender's account
        UPDATE Accounts 
        SET Balance = Balance - p_amount, LastModified = SYSDATE 
        WHERE AccountID = p_source_account;
        
        -- Add the amount to the receiver's account
        UPDATE Accounts 
        SET Balance = Balance + p_amount, LastModified = SYSDATE 
        WHERE AccountID = p_dest_account;
        
        DBMS_OUTPUT.PUT_LINE('Successfully transferred $' || p_amount || ' from Account ' || p_source_account || ' to Account ' || p_dest_account);
        COMMIT;
    END IF;
EXCEPTION
    -- Handle case where an account number does not exist in the database
    WHEN NO_DATA_FOUND THEN
        DBMS_OUTPUT.PUT_LINE('Transaction Failed: Invalid Account ID referenced.');
    WHEN OTHERS THEN
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE('Transaction Aborted: An unexpected error occurred: ' || SQLERRM);
END;
/