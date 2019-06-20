CREATE TABLE inspections
(
    inspection_id INT PRIMARY KEY,
    dba_name TEXT,
    aka_name TEXT,
    license_no INT,
    facility_type TEXT,
    risk TEXT,
    address TEXT,
    city TEXT,
    State TEXT,
    zip INT,
    inspection_date TEXT,
    inspection_type TEXT,
    results TEXT,
    violations TEXT,
    latitude FLOAT8,
    longitude FLOAT8,
    location TEXT
);