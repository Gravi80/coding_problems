package com.geektrust.family_tree.relations;

import com.geektrust.family_tree.Parents;
import com.geektrust.family_tree.Person;
import com.geektrust.family_tree.constants.Gender;

import java.util.ArrayList;
import java.util.List;

public class Brother implements Relation {
    public List<Person> getFor(Person person){
        return getBrothersOf(person);
    }

    @Override
    public String name() {
        return "Brother";
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
