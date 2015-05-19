package com.geektrust.meet_the_family.relations;

import com.geektrust.meet_the_family.Parents;
import com.geektrust.meet_the_family.Person;
import com.geektrust.meet_the_family.helpers.Gender;

import java.util.ArrayList;
import java.util.List;


public class Sister implements Relation {

    @Override
    public List<Person> getFor(Person person) {
        return getSistersOf(person);
    }

    private List<Person> getSistersOf(Person person) {
        ArrayList<Person> sisters = new ArrayList<>();
        Parents parents = person.getParents();
        if (parents==null) return sisters;
        List<Person> childrens = parents.getFather().getChildrens();
        for (Person children : childrens) {
            if (children.getGender() == Gender.FEMALE && children != person ) sisters.add(children);
        }
        return sisters;
    }

}
