package com.geektrust.meet_the_family.relations;

import com.geektrust.meet_the_family.Parents;
import com.geektrust.meet_the_family.Person;
import com.geektrust.meet_the_family.helpers.Gender;

import java.util.ArrayList;
import java.util.List;

public class Brother implements Relation {
    public List<Person> getFor(Person person){
        return getBrothersOf(person);
    }

    private List<Person> getBrothersOf(Person person) {
        ArrayList<Person> brothers = new ArrayList<>();
        Parents parents = person.getParents();
        if (parents ==null) return brothers;
        List<Person> childrens = parents.getFather().getChildrens();
        for (Person children : childrens) {
            if ((children.getGender() == Gender.MALE) && children != person) brothers.add(children);
        }
        return brothers;
    }
}
