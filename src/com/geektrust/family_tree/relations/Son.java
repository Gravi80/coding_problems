package com.geektrust.family_tree.relations;

import com.geektrust.family_tree.Person;
import com.geektrust.family_tree.constants.Gender;


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

    @Override
    public String name() {
        return "Son";
    }
}
