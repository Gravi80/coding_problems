package com.geektrust.meet_the_family.relations;

import com.geektrust.meet_the_family.Person;

import java.util.ArrayList;
import java.util.List;


public class Father implements Relation {
    @Override
    public List<Person> getFor(Person person) {
        ArrayList<Person> father = new ArrayList<>();
        if (person.getParents() == null || person.getParents().getFather() == null) return father;
        father.add(person.getParents().getFather());
        return father;
    }
}
