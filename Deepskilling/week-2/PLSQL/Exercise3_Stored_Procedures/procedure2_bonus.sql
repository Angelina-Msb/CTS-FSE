CREATE OR REPLACE PROCEDURE UpdateEmployeeBonus (
    p_department     IN VARCHAR2, -- Accepts the department name as an input parameter
    p_bonus_percent  IN NUMBER    -- Accepts the bonus percentage (e.g., 5 for 5%)
) AS
BEGIN
    -- 1. Increase salary using the parameter values provided when calling the procedure
    UPDATE Employees 
    SET Salary = Salary + (Salary * (p_bonus_percent / 100))
    WHERE Department = p_department;
    
    -- 2. Confirm the update in the logs
    DBMS_OUTPUT.PUT_LINE('Successfully applied a ' || p_bonus_percent || 
                         '% bonus to all employees in the ' || p_department || ' department.');
    COMMIT;
EXCEPTION
    WHEN OTHERS THEN
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE('Error processing employee bonuses: ' || SQLERRM);
END;
/