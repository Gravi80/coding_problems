package com.geektrust.meet_the_family.relations;

import com.geektrust.meet_the_family.Person;
import com.geektrust.meet_the_family.helpers.Gender;


import java.util.ArrayList;
import java.util.List;


public class Son implements Relation {
    @Override
    public List<Person> getFor(Person person) {
        ArrayList<Person> sons = new ArrayList<>();
        for (Person child : person.getChildrens()) {
            if(child.getGender()== Gender.MALE) sons.add(child);
        }
        return sons;
    }
}
