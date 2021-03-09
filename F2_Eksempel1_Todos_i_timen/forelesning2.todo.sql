-- Skript for å opprette databasen og legge inn litt data
    -- Skjema = forelesning2
        -- Tabell(er) = todo 

-- MERK!!! DROP SCHEMA ... CASCADE sletter alt !!!
DROP SCHEMA IF EXISTS forelesning2 CASCADE;

CREATE SCHEMA forelesning2;
SET search_path TO forelesning2;
    
-- Ikke nødvendig å slette tabellen(e) siden vi har tomt skjema, men ...
-- DROP TABLE todo;

CREATE TABLE todo
(
    id INTEGER,
    tekst VARCHAR NOT NULL,
    CONSTRAINT todo_pk PRIMARY KEY (id)
);

INSERT INTO
  todo(id, tekst)
VALUES
    (1, 'Handle mat'),
    (2, 'Vaske opp'),
    (3, 'Ta ut bosset');

