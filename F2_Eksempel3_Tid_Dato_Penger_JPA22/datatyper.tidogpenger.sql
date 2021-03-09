-- Skript for å opprette databasen og legge inn litt data
    -- Skjema = datatyper
        -- Tabell(er) = tidogpenger 

-- MERK!!! DROP SCHEMA ... CASCADE sletter alt !!!
DROP SCHEMA IF EXISTS datatyper CASCADE;

CREATE SCHEMA datatyper;
SET search_path TO datatyper;
    
-- Ikke nødvendig å slette tabellen(e) siden vi har tomt skjema, men ...
-- DROP TABLE tidogpenger;

-- Se https://www.postgresql.org/docs/8.0/static/datatype.html
-- for en oversikt over PostgreSQL datatyper

CREATE TABLE tidogpenger
(
    id SERIAL,
    belop DECIMAL(10, 2),
    dato DATE,
    klokkeslett TIME,
    tidsstempel TIMESTAMP,
    CONSTRAINT tidogpenger_pk PRIMARY KEY (id)
);

INSERT INTO
  tidogpenger(belop, dato, klokkeslett, tidsstempel)
VALUES
    (4.10, '2018-03-20', '04:05:06', '2004-10-19 10:23:54');

SELECT * FROM datatyper.tidogpenger;

