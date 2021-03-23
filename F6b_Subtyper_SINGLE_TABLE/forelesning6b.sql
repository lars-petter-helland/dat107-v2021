--
-- Eksempel F6b forelesning onsdag 24. mars 2021.
--
-- Alternativ b: Subtyping med tabell kun for supertypen,
-- dvs. @Inheritance(strategy = InheritanceType.SINGLE_TABLE)
--

DROP SCHEMA IF EXISTS forelesning6b CASCADE;
CREATE SCHEMA forelesning6b;
SET search_path TO forelesning6b;

CREATE TABLE Person
(
  FNr        CHAR(11), -- Kan også bruke UNSIGNED BIGINT(11). 
                       -- INTEGER er for liten for 11 sifre.
  Fornavn    VARCHAR(30),
  Etternavn  VARCHAR(30),
  Persontype CHAR(1),
  Stilling   VARCHAR(30),
  Studium    VARCHAR(30),
  CONSTRAINT Person_PK PRIMARY KEY (FNr)
);

INSERT INTO 
    Person(FNr, Fornavn, Etternavn, Persontype, Stilling, Studium)
VALUES
    ('12345678901', 'Arne', 'Arnesen', 'A', 'Lærer', NULL),
    ('23456789012', 'Stig', 'Stigsen', 'S', NULL, 'Dataingeniør'),
    ('34567890123', 'Pers', 'Perssen', 'P', NULL, NULL);
    

