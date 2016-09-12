package com.geektrust.family_tree.relations;


import com.geektrust.family_tree.Person;

import java.util.List;

public interface Relation {
    List<Person> getFor(Person person);
    String name();
}
