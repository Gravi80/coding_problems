package com.geektrust.meet_the_family.relations;

import com.geektrust.meet_the_family.Person;
import com.geektrust.meet_the_family.helpers.Gender;

import java.util.ArrayList;
import java.util.List;


public class Daughter implements Relation {

    @Override
    public List<Person> getFor(Person person) {
        ArrayList<Person> daughters = new ArrayList<>();
        for (Person child : person.getChildrens()) {
            if(child.getGender()== Gender.FEMALE) daughters.add(child);
        }
        return daughters;
    }
}
