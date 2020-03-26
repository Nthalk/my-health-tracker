DROP OWNED BY myhealthtracker;
REASSIGN OWNED BY myhealthtracker TO postgres;
DROP DATABASE myhealthtracker;
CREATE DATABASE myhealthtracker;

DROP OWNED BY myhealthtracker CASCADE;
DROP USER myhealthtracker;
CREATE USER myhealthtracker WITH PASSWORD 'myhealthtracker';
GRANT CONNECT ON DATABASE myhealthtracker TO myhealthtracker;
GRANT USAGE ON SCHEMA public TO myhealthtracker;
GRANT ALL PRIVILEGES ON ALL TABLES IN SCHEMA public TO myhealthtracker;
GRANT ALL PRIVILEGES ON ALL SEQUENCES IN SCHEMA public TO myhealthtracker;
ALTER USER myhealthtracker WITH SUPERUSER;
