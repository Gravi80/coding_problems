package com.geektrust.family_tree.relations;

import com.geektrust.family_tree.Parents;
import com.geektrust.family_tree.Person;
import com.geektrust.family_tree.constants.Gender;

import java.util.ArrayList;
import java.util.List;


public class Sister implements Relation {

    @Override
    public List<Person> getFor(Person person) {
        return getSistersOf(person);
    }

    @Override
    public String name() {
        return "Sister";
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
