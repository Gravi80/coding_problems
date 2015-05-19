package com.geektrust.meet_the_family.relations;


import com.geektrust.meet_the_family.Person;

import java.util.List;

public interface Relation {
    public List<Person> getAll(Person person);
}
