package com.geektrust.family_tree.relations;

import com.geektrust.family_tree.constants.Gender;
import com.geektrust.family_tree.Person;

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

    @Override
    public String name() {
        return "Daughter";
    }
}
