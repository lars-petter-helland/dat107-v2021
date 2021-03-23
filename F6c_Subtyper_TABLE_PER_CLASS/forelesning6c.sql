--
-- Eksempel F6c forelesning onsdag 24. mars 2021.
--
-- Alternativ c: Subtyping med tabell kun for subtypene,
-- dvs. @Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)

DROP SCHEMA IF EXISTS forelesning6c CASCADE;
CREATE SCHEMA forelesning6c;
SET search_path TO forelesning6c;

CREATE TABLE Person
(
  FNr        CHAR(11), -- Kan også bruke UNSIGNED BIGINT(11). 
                       -- INTEGER er for liten for 11 sifre.
  Fornavn    VARCHAR(30),
  Etternavn  VARCHAR(30),
  CONSTRAINT Person_PK PRIMARY KEY (FNr)
);

CREATE TABLE Ansatt
(
  FNr        CHAR(11), -- Kan også bruke UNSIGNED BIGINT(11). 
                       -- INTEGER er for liten for 11 sifre.
  Fornavn    VARCHAR(30),
  Etternavn  VARCHAR(30),
  Stilling   VARCHAR(30),
  CONSTRAINT Ansatt_PK PRIMARY KEY (FNr)
);

CREATE TABLE Student
(
  FNr        CHAR(11), -- Kan også bruke UNSIGNED BIGINT(11). 
                       -- INTEGER er for liten for 11 sifre.
  Fornavn    VARCHAR(30),
  Etternavn  VARCHAR(30),
  Studium    VARCHAR(30),
  CONSTRAINT Student_PK PRIMARY KEY (FNr)
);

INSERT INTO 
    Person(FNr, Fornavn, Etternavn)
VALUES
    ('34567890123', 'Pers', 'Perssen');

INSERT INTO 
    Ansatt(FNr, Fornavn, Etternavn, Stilling)
VALUES
    ('12345678901', 'Arne', 'Arnesen', 'Lærer');
    
INSERT INTO 
    Student(FNr, Fornavn, Etternavn, Studium)
VALUES
    ('23456789012', 'Stig', 'Stigsen', 'Dataingeniør');
    

