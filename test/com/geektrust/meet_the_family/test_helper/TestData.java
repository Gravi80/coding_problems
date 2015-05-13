package com.geektrust.meet_the_family.test_helper;


import com.geektrust.meet_the_family.Family;
import com.geektrust.meet_the_family.Person;
import com.geektrust.meet_the_family.helpers.Gender;
import com.geektrust.meet_the_family.helpers.Relation;

public class TestData {

    public static Family generateShahFamily() {
        Family family = new Family("Shan");

        Person kingShah = new Person("Shan", Gender.MALE);
        Person queenAnga = new Person("Anga", Gender.FEMALE);
        Person ish = new Person("Ish", Gender.MALE);
        Person chit = new Person("Chit", Gender.MALE);
        Person vich = new Person("Vich", Gender.MALE);
        Person satya = new Person("Satya", Gender.FEMALE);

        kingShah.addRelative(Relation.WIFE, queenAnga).alsoAddSelfAsARelative();
        kingShah.addRelative(Relation.SON, ish).alsoAddSelfAsARelative();
        kingShah.addRelative(Relation.SON, chit).alsoAddSelfAsARelative();
        kingShah.addRelative(Relation.SON, vich).alsoAddSelfAsARelative();
        kingShah.addRelative(Relation.DAUGHTER, satya).alsoAddSelfAsARelative();

        queenAnga.addRelative(Relation.SON, ish).alsoAddSelfAsARelative();
        queenAnga.addRelative(Relation.SON, chit).alsoAddSelfAsARelative();
        queenAnga.addRelative(Relation.SON, vich).alsoAddSelfAsARelative();
        queenAnga.addRelative(Relation.DAUGHTER, satya).alsoAddSelfAsARelative();

        ish.addRelative(Relation.BROTHER, chit).alsoAddSelfAsARelative();
        ish.addRelative(Relation.BROTHER, vich).alsoAddSelfAsARelative();
        ish.addRelative(Relation.SISTER, satya).alsoAddSelfAsARelative();

        family.addPerson(kingShah);
        family.addPerson(queenAnga);
        family.addPerson(ish);
        family.addPerson(chit);
        family.addPerson(vich);
        family.addPerson(satya);
        return family;
    }
}
