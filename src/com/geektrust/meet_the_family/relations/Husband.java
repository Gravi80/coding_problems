package com.geektrust.meet_the_family.relations;


import com.geektrust.meet_the_family.Person;
import com.geektrust.meet_the_family.helpers.Gender;

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
}
