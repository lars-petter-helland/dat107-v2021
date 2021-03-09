-- Skript for å opprette databasen og legge inn litt data
    -- Skjema = autogen_id
        -- Tabell(er) = person 

-- MERK!!! DROP SCHEMA ... CASCADE sletter alt !!!
DROP SCHEMA IF EXISTS autogen_id CASCADE;

CREATE SCHEMA autogen_id;
SET search_path TO autogen_id;
    
-- Ikke nødvendig å slette tabellen(e) siden vi har tomt skjema, men ...
-- DROP TABLE person;

CREATE TABLE person
(
    id SERIAL,
    navn VARCHAR(30) NOT NULL,
    CONSTRAINT person_pk PRIMARY KEY (id)
);

INSERT INTO
  person(navn)
VALUES
    ('Per Viskeler'),
    ('Atle Patle'),
    ('Donald Duck');

