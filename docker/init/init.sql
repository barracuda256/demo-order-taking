SELECT 'CREATE DATABASE demo'
WHERE NOT EXISTS (SELECT FROM pg_database WHERE datname = 'mydb')\gexec
GRANT ALL PRIVILEGES ON database demo TO postgres;
