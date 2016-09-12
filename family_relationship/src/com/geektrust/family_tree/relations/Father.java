package com.geektrust.family_tree.relations;

import com.geektrust.family_tree.Person;

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

    @Override
    public String name() {
        return "Father";
    }
}
