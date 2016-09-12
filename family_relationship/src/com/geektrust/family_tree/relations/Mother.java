package com.geektrust.family_tree.relations;


import com.geektrust.family_tree.Person;

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

    @Override
    public String name() {
        return "Mother";
    }
}
