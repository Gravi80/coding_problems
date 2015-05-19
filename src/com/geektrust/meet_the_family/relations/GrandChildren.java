package com.geektrust.meet_the_family.relations;


import com.geektrust.meet_the_family.Person;

import java.util.ArrayList;
import java.util.List;

public class GrandChildren implements Relation {
    @Override
    public List<Person> getFor(Person person) {
        ArrayList<Person> grandChildrens = new ArrayList<>();
        for (Person child : person.getChildrens()) {
            grandChildrens.addAll(child.getChildrens());
        }

        return grandChildrens;
    }

}
