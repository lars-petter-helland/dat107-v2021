-- Mange-til-mange-eksempel forelesning tirsdag 14. april 2020.

-- MERK!!! DROP SCHEMA ... CASCADE sletter alt !!!
DROP SCHEMA IF EXISTS forelesning5a CASCADE;
CREATE SCHEMA forelesning5a;
SET search_path TO forelesning5a;

CREATE TABLE Ansatt
(
  Id         SERIAL,
  Fornavn    VARCHAR(30),
  Etternavn  VARCHAR(30),
  CONSTRAINT Ansatt_PK PRIMARY KEY (Id)
);

CREATE TABLE Prosjekt
(
  Id        SERIAL,
  Navn      VARCHAR(30),
  CONSTRAINT Prosjekt_PK PRIMARY KEY (Id)
);

-- Mange-til-mange må løses med en koblingstabell, slik:
CREATE TABLE Prosjektdeltagelse
(
  Ansatt_Id INTEGER,
  Prosjekt_Id INTEGER,
  CONSTRAINT Prosjektdeltagelse_PK PRIMARY KEY (Ansatt_Id, Prosjekt_Id),
  CONSTRAINT Ansatt_FK FOREIGN KEY (Ansatt_Id) REFERENCES Ansatt(Id),
  CONSTRAINT Prosjekt_FK FOREIGN KEY (Prosjekt_Id) REFERENCES Prosjekt(Id)  
);

INSERT INTO
  Ansatt(Fornavn, Etternavn)
VALUES
  ('Arne', 'Arnesen'),
  ('Brit', 'Britsen'),
  ('Carl', 'Carlsen'),
  ('Donald', 'Duck');

INSERT INTO
  Prosjekt(Navn)
VALUES
  ('Trivselsprosjektet'),
  ('Synergiprosjektet'),
  ('Utviklingsprosjektet');

INSERT INTO
  Prosjektdeltagelse(Ansatt_Id, Prosjekt_Id)
VALUES
  (1, 1),
  (2, 1),
  (2, 2),
  (3, 1),
  (3, 2),
  (4, 1);

  