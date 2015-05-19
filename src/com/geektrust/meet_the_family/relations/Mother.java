package com.geektrust.meet_the_family.relations;


import com.geektrust.meet_the_family.Person;
import com.geektrust.meet_the_family.helpers.Gender;

import java.util.ArrayList;
import java.util.List;

public class Mother implements Relation {

    @Override
    public List<Person> getFor(Person person) {
        ArrayList<Person> mother = new ArrayList<>();
        if (person.getParents() == null || person.getParents().getMother() == null) return mother;
        mother.add(person.getParents().getMother());
        return mother;
    }
}
