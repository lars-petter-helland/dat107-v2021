-- Skript for å opprette databasen og legge inn litt data
    -- Skjema = hello_jpa
        -- Tabell(er) = person 

-- MERK!!! DROP SCHEMA ... CASCADE sletter alt !!!
DROP SCHEMA IF EXISTS hello_jpa CASCADE;

CREATE SCHEMA hello_jpa;
SET search_path TO hello_jpa;
    
-- Ikke nødvendig å slette tabellen(e) siden vi har tomt skjema, men ...
-- DROP TABLE person;

CREATE TABLE person
(
    id integer NOT NULL,
    navn VARCHAR(30) NOT NULL,
    CONSTRAINT person_pk PRIMARY KEY (id)
);

INSERT INTO
  person(id, navn)
VALUES
    (1001, 'Per Viskeler'),
    (1002, 'Atle Patle'),
    (1003, 'Donald Duck');

