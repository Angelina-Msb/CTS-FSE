-- Tell the database tool to show printed messages
SET SERVEROUTPUT ON;

--------------------------------------------------------
-- 1. DROP TABLES (To reset cleanly if you run it twice)
--------------------------------------------------------
DROP TABLE Transactions CASCADE CONSTRAINTS;
DROP TABLE Loans CASCADE CONSTRAINTS;
DROP TABLE Accounts CASCADE CONSTRAINTS;
DROP TABLE Customers CASCADE CONSTRAINTS;
DROP TABLE Employees CASCADE CONSTRAINTS;

--------------------------------------------------------
-- 2. CREATE TABLES
--------------------------------------------------------

-- Table A: Customers
CREATE TABLE Customers (
    CustomerID NUMBER PRIMARY KEY,
    Name VARCHAR2(100),
    DOB DATE,
    Balance NUMBER,
    LastModified DATE,
    IsVIP VARCHAR2(5) DEFAULT 'FALSE'
);

-- Table B: Accounts
CREATE TABLE Accounts (
    AccountID NUMBER PRIMARY KEY,
    CustomerID NUMBER,
    AccountType VARCHAR2(20),
    Balance NUMBER,
    LastModified DATE,
    FOREIGN KEY (CustomerID) REFERENCES Customers(CustomerID)
);

-- Table C: Transactions
CREATE TABLE Transactions (
    TransactionID NUMBER PRIMARY KEY,
    AccountID NUMBER,
    TransactionDate DATE,
    Amount NUMBER,
    TransactionType VARCHAR2(10),
    FOREIGN KEY (AccountID) REFERENCES Accounts(AccountID)
);

-- Table D: Loans
CREATE TABLE Loans (
    LoanID NUMBER PRIMARY KEY,
    CustomerID NUMBER,
    LoanAmount NUMBER,
    InterestRate NUMBER,
    StartDate DATE,
    EndDate DATE,
    FOREIGN KEY (CustomerID) REFERENCES Customers(CustomerID)
);

-- Table E: Employees
CREATE TABLE Employees (
    EmployeeID NUMBER PRIMARY KEY,
    Name VARCHAR2(100),
    Position VARCHAR2(50),
    Salary NUMBER,
    Department VARCHAR2(50),
    HireDate DATE
);

--------------------------------------------------------
-- 3. INSERT DUMMY DATA FOR TESTING
--------------------------------------------------------

-- Insert Customers (One over 60 for the senior discount exercise, one under)
INSERT INTO Customers VALUES (1, 'Alice Smith', TO_DATE('1955-03-12', 'YYYY-MM-DD'), 12000, SYSDATE, 'FALSE');
INSERT INTO Customers VALUES (2, 'Bob Jones', TO_DATE('1985-07-22', 'YYYY-MM-DD'), 4500, SYSDATE, 'FALSE');

-- Insert Accounts (One Savings for the interest exercise, one Checking)
INSERT INTO Accounts VALUES (101, 1, 'Savings', 5000, SYSDATE);
INSERT INTO Accounts VALUES (102, 2, 'Checking', 2500, SYSDATE);

-- Insert Loans (One due within 30 days for the reminder exercise, one further out)
INSERT INTO Loans VALUES (501, 1, 50000, 0.08, SYSDATE - 300, SYSDATE + 15);
INSERT INTO Loans VALUES (502, 2, 15000, 0.09, SYSDATE - 100, SYSDATE + 180);

-- Insert Employees
INSERT INTO Employees VALUES (1001, 'John Doe', 'Developer', 60000, 'IT', TO_DATE('2022-01-15', 'YYYY-MM-DD'));
INSERT INTO Employees VALUES (1002, 'Jane Doe', 'Manager', 85000, 'HR', TO_DATE('2021-06-01', 'YYYY-MM-DD'));

-- Save all records permanently
COMMIT;