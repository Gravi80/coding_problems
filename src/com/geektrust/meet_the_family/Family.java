package com.geektrust.meet_the_family;

import java.util.ArrayList;
import java.util.List;

public class Family {
    private String familyName;

    private List<Person> people;

    public Family(String familyName) {
        this.familyName = familyName;
        this.people=new ArrayList<>();
    }

    public String getFamilyName() {
        return familyName;
    }

    public void addPerson(Person person){
        people.add(person);
    }

    public List<Person> getAllPeople(){
        return people;
    }
}
