package com.geektrust.meet_the_family;


import com.geektrust.meet_the_family.helpers.Relation;

import java.util.ArrayList;
import java.util.List;

public class RelationShipFinder {

    private final Family family;

    public RelationShipFinder(Family family) {
        this.family = family;
    }

    public List<String> find(Relation relation, String person_name) {
        List<String> relativesNames = new ArrayList<>();
        Person person = findPersonWithName(person_name);
        if (person != null) {
            List<Person> relatives = person.getAll(relation);
            for (Person relative : relatives) {
                relativesNames.add(relative.getName());
            }
        }
        return relativesNames;
    }

    private Person findPersonWithName(String name) {
        for (Person person : family.getAllPeople()) {
            if (person.getName().equals(name)) return person;
        }
        return null;
    }

}
