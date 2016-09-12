package com.geektrust.family_tree;

import com.geektrust.family_tree.constants.Gender;
import com.geektrust.family_tree.families.ShanFamily;
import com.geektrust.family_tree.relations.Brother;
import com.geektrust.family_tree.relations.GrandChildren;

import java.util.List;
import java.util.Set;

public class MainClass {
    public static void main(String[] args) {
        ShanFamily shanFamily = new ShanFamily();
        shanFamily.generatePeople();
        shanFamily.associatePeople();
        RelationShipFinder relationShipFinder = new RelationShipFinder();

//      Problem 1 : Meet the family
        Person ish = shanFamily.findPersonWithName("Ish");
        List<String> brothersName = relationShipFinder.find(ish, new Brother());

        print(brothersName);  // Chit, Vich


//      Problem 3 : The girl child
        Set<String> mothersName = relationShipFinder.getMothersWithMostGirlChild(shanFamily);
        print(mothersName); // Jnki,Satya,Lika,Jaya

        Person drini = new Person("Drini", Gender.FEMALE);
        shanFamily.findPersonWithName("Jaya").addChild(drini);

        print(relationShipFinder.getMothersWithMostGirlChild(shanFamily)); // Jaya


//      Problem 2 : A new born
        Person vanya = new Person("Vanya", Gender.FEMALE);
        shanFamily.findPersonWithName("Lavnya").addChild(vanya);


        Person jnki = shanFamily.findPersonWithName("Jnki");
        List<String> grandChildrenNames = relationShipFinder.find(jnki, new GrandChildren());

        print(grandChildrenNames); // Vanya

    }



    private static void print(Iterable<String> names) {
        for (String name : names) {
            System.out.println(name);
        }
    }
}
