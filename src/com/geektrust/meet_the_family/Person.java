package com.geektrust.meet_the_family;

import com.geektrust.meet_the_family.helpers.Gender;
import com.geektrust.meet_the_family.helpers.Relation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Person {
    private String name;

    private Gender gender;

    private Map<Relation, List<Person>> relatives;

    //    #TODO: Need to look for a cleaner approach
    private Relation recentlyAddedPersonRelation;
    private Person recentlyAddedPerson;

    public Person(String name, Gender gender) {
        this.name = name;
        this.gender = gender;
        this.relatives = new HashMap<>();
    }

    public String getName() {
        return name;
    }

    public Person addRelative(Relation relation, Person relative) {
        if (!isRelationPresent(relation)) initializePersonListFor(relation);
        recentlyAddedPerson = relative;
        recentlyAddedPersonRelation = relation;
        relatives.get(relation).add(relative);
        return this;
    }

    public void alsoAddSelfAsARelative() {
        recentlyAddedPerson.addRelative(recentlyAddedPersonRelation.getOppositeRelation(recentlyAddedPerson.gender), this);
    }

    public List<Person> getAll(Relation relation) {
        return relatives.get(relation) == null ? new ArrayList<>() : relatives.get(relation);
    }

    private void initializePersonListFor(Relation relation) {
        ArrayList<Person> people = new ArrayList<>();
        relatives.put(relation, people);
    }

    private boolean isRelationPresent(Relation relation) {
        return relatives.containsKey(relation);
    }

}
