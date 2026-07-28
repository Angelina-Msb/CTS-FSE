SET SERVEROUTPUT ON;

DECLARE
    -- Cursor to select customer details
    CURSOR c_customers IS 
        SELECT CustomerID, Name, Balance 
        FROM Customers;
BEGIN
    FOR r_cust IN c_customers LOOP
        -- Control Structure: Check if the balance exceeds $10,000
        IF r_cust.Balance > 10000 THEN
            UPDATE Customers 
            SET IsVIP = 'TRUE' 
            WHERE CustomerID = r_cust.CustomerID;
            
            DBMS_OUTPUT.PUT_LINE('Customer ' || r_cust.Name || ' (ID: ' || r_cust.CustomerID || ') promoted to VIP!');
        ELSE
            UPDATE Customers 
            SET IsVIP = 'FALSE' 
            WHERE CustomerID = r_cust.CustomerID;
        END IF;
    END LOOP;
    
    COMMIT;
END;
/