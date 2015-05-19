package com.geektrust.meet_the_family.test_helper;


import com.geektrust.meet_the_family.Person;
import com.geektrust.meet_the_family.helpers.Gender;

public class TestData {

    public static Person generateShanFamily() {

        Person kingShan = new Person("Shan", Gender.MALE);
        Person queenAnga = new Person("Anga", Gender.FEMALE);
        Person ish = new Person("Ish", Gender.MALE);
        Person chit = new Person("Chit", Gender.MALE);
        Person vich = new Person("Vich", Gender.MALE);
        Person satya = new Person("Satya", Gender.FEMALE);

        kingShan.setSpouse(queenAnga).addChild(ish).addChild(chit).addChild(vich).addChild(satya);

        return kingShan;
    }
}
