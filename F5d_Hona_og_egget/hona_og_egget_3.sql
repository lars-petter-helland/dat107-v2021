-- Fikk altså ERROR:  insert or update on table "avdeling" violates 
--     foreign key constraint "sjef_fk"
-- DETAIL:  Key (sjef_id)=(1) is not present in table "ansatt".

-- Det hjelper jo ikke å lage en Ansatt først (samme problem, 
-- men omvendt).

-- Løsning: Legge til sjef etterpå.

DROP SCHEMA IF EXISTS f5d CASCADE;
CREATE SCHEMA f5d;
SET search_path TO f5d;

CREATE TABLE Avdeling (
  Id         SERIAL,
  Navn       VARCHAR(30),
  Sjef_Id    INTEGER NOT NULL, -- En avdeling MÅ ha en sjef
  CONSTRAINT Avdeling_PK PRIMARY KEY (Id)
);

CREATE TABLE Ansatt (
  Id         SERIAL,
  Navn       VARCHAR(30),
  Avd_Id     INTEGER NOT NULL, -- En ansatt MÅ jobbe for en avdeling
  CONSTRAINT Ansatt_PK PRIMARY KEY (Id),
  CONSTRAINT Avdeling_FK FOREIGN KEY (Avd_Id) 
  		REFERENCES Avdeling(Id) -- med referanse til en Avdeling
);

ALTER TABLE Avdeling ADD CONSTRAINT Sjef_FK FOREIGN KEY (Sjef_Id) 
  		REFERENCES Ansatt(Id);  -- med referanse til en Ansatt

  		
  		
INSERT INTO Avdeling(Navn) VALUES
  ('Administrasjon'); -- Prøver uten sjef 
  
-- ERROR:  null value in column "sjef_id" violates not-null constraint
-- DETAIL:  Failing row contains (1, Administrasjon, null).

  
INSERT INTO Ansatt(Navn, Avd_Id) VALUES
  ('Arne', 1); -- Prøver med en avdeling (avdeling nr 1)

UPDATE Avdeling SET Sjef_Id = 1 WHERE Id = 1; -- Arne er sjef for Administrasjon
  

-- Deretter burde det gå greit!?
INSERT INTO Ansatt(Navn, Avd_Id) VALUES
  ('Brit', 1), ('Carl', 1), ('Dina', 1);
 
INSERT INTO Avdeling (Navn, Sjef_Id) VALUES
  ('Personal', 3); -- Prøver med Carl som sjef (ansatt nr 3)
UPDATE Ansatt SET Avd_Id = 2 WHERE Id = 3;

INSERT INTO Ansatt(Navn, Avd_Id) VALUES
  ('Erik', 2), ('Fred', 2), ('Gerd', 2);

