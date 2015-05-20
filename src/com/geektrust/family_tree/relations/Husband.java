package com.geektrust.family_tree.relations;


import com.geektrust.family_tree.Person;
import com.geektrust.family_tree.constants.Gender;

import java.util.ArrayList;
import java.util.List;

public class Husband implements Relation {
    @Override
    public List<Person> getFor(Person person) {
        ArrayList<Person> husband = new ArrayList<>();
        if(person.getGender()== Gender.MALE) return husband;
        husband.add(person.getSpouse());
        return husband;
    }

    @Override
    public String name() {
        return "Husband";
    }
}
