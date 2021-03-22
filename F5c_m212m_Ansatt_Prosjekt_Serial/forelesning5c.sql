-- Mange-til-en-til-mange-eksempel forelesning tirsdag 22. mars 2021.

-- MERK!!! DROP SCHEMA ... CASCADE sletter alt !!!
DROP SCHEMA IF EXISTS forelesning5c CASCADE;
CREATE SCHEMA forelesning5c;
SET search_path TO forelesning5c;

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

-- Koblingstabellen har i dette tilfellet egne data (timer)
-- Blir da en egen selvstendig entitet.
-- Nå med surrugatnøkkel for å forenkle kodingen.
CREATE TABLE Prosjektdeltagelse
(
  Prosjektdeltagelse_Id SERIAL,
  Ansatt_Id INTEGER,
  Prosjekt_Id INTEGER,
  Timer     INTEGER,
  CONSTRAINT Prosjektdeltagelse_PK PRIMARY KEY (Prosjektdeltagelse_Id),
  CONSTRAINT AnsattProsjekt_Unik UNIQUE NOT NULL (Ansatt_Id, Prosjekt_Id),
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
  Prosjektdeltagelse(Ansatt_Id, Prosjekt_Id, Timer)
VALUES
  (1, 1, 50),
  (2, 1, 100),
  (2, 2, 150),
  (3, 1, 200),
  (3, 2, 250),
  (4, 1, 300);

  