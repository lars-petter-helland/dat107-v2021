package no.hvl.dat107.entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(schema = "forelesning6b")
@DiscriminatorValue(value = "S")
public class Student extends Person { 

    private String studium;
    
    public Student() {}

    public Student(String fNr, String fornavn, String etternavn, String studium) {
        super(fNr, fornavn, etternavn);
        this.studium = studium;
    }
    
    @Override
    public String toString() {
        return super.toString() + ", studium=" + studium;
    }
    
}

