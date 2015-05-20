package com.geektrust.family_tree.relations;


import com.geektrust.family_tree.Person;

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

    @Override
    public String name() {
        return "Grand Children";
    }

}
