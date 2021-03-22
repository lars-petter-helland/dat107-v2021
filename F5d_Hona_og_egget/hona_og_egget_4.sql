-- Litt det samme som i sted.
-- Fikk nå ERROR:  null value in column "sjef_id" violates not-null constraint
-- DETAIL:  Failing row contains (1, Administrasjon, null).

-- Løsning: Vi kan vente med å legge på en av disse contraintene til vi har
--          lagt inn data for én Avdeling og én Ansatt.

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
  	

INSERT INTO Avdeling(Navn, Sjef_Id) VALUES
  ('Administrasjon', 1); -- Prøver igjen med en sjef (ansatt nr 1) som ikke finnes 
  
INSERT INTO Ansatt(Navn, Avd_Id) VALUES
  ('Arne', 1); -- Prøver med en avdeling (avdeling nr 1)
  
ALTER TABLE Avdeling ADD CONSTRAINT Sjef_FK FOREIGN KEY (Sjef_Id) 
  		REFERENCES Ansatt(Id);  

  		
-- Deretter burde det gå greit!?
-- Dvs. alt etter her bør kunne gjøres via JPA
INSERT INTO Ansatt(Navn, Avd_Id) VALUES
  ('Brit', 1), 
  ('Carl', 1), 
  ('Dina', 1);
 
INSERT INTO Avdeling (Navn, Sjef_Id) VALUES
  ('Personal', 3); -- Prøver med Carl som sjef (ansatt nr 3)
UPDATE Ansatt SET Avd_Id = 2 WHERE Id = 3; -- Endrer Carl sin avdeling til 2

INSERT INTO Ansatt(Navn, Avd_Id) VALUES
  ('Erik', 2), 
  ('Fred', 2), 
  ('Gerd', 2);

