package com.geektrust.family_tree;


public class Parents {
    private Person mother;
    private Person father;

    public Parents(Person mother, Person father) {
        this.mother = mother;
        this.father = father;
    }

    public Person getMother() {
        return mother;
    }

    public void setMother(Person mother) {
        this.mother = mother;
    }

    public Person getFather() {
        return father;
    }

    public void setFather(Person father) {
        this.father = father;
    }
}
