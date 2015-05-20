package com.geektrust.family_tree.families;

import com.geektrust.family_tree.Person;

import java.util.List;

public interface Family {
    void generatePeople();
    Family associatePeople();
    Person findPersonWithName(String name);
    List<Person> femaleMembers();
    Person getHeadOfFamily();
}
