-- Create Database
CREATE DATABASE IF NOT EXISTS studentdb;

-- Use Database
USE studentdb;

-- Create Students Table
CREATE TABLE IF NOT EXISTS students (
    id INT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    age INT NOT NULL,
    course VARCHAR(100) NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL
);

-- Sample Data
INSERT INTO students (id, name, age, course, email)
VALUES
(101, 'Harshit', 20, 'B.Tech CSIT', 'harshit@example.com'),
(102, 'Rahul', 21, 'B.Tech CSE', 'rahul@example.com'),
(103, 'Priya', 19, 'B.Tech IT', 'priya@example.com');
