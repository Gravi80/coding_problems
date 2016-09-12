package com.geektrust.meet_the_family.relations;

import com.geektrust.family_tree.Person;
import com.geektrust.family_tree.constants.Gender;
import com.geektrust.family_tree.relations.Brother;
import com.geektrust.family_tree.relations.Relation;
import org.hamcrest.core.IsEqual;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;


public class BrotherTest {
    private Person kingShah;
    private Person queenAnga;
    Relation brother = new Brother();

    @Before
    public void setUp() throws Exception {
        kingShah = new Person("Shan", Gender.MALE);
        queenAnga = new Person("Anga", Gender.FEMALE);

    }

    @Test
    public void shouldReturnAllBrothersOfPerson() {
        Person ish = new Person("Ish", Gender.MALE);
        Person chit = new Person("Chit", Gender.MALE);
        Person satya = new Person("Satya", Gender.FEMALE);

        kingShah.setSpouse(queenAnga).addChild(ish).addChild(chit).addChild(satya);

        List<Person> brothers = brother.getFor(ish);

        assertThat(brothers.size(), IsEqual.equalTo(1));
    }

    @Test
    public void shouldReturnSameBrothersCountForTwoBrothers() {
        Person ish = new Person("Ish", Gender.MALE);
        Person chit = new Person("Chit", Gender.MALE);

        kingShah.setSpouse(queenAnga).addChild(ish).addChild(chit);

        assertThat(brother.getFor(ish).size(), IsEqual.equalTo(brother.getFor(chit).size()));
    }

    @Test
    public void shouldReturnBrotherOfASister() {
        Person ish = new Person("Ish", Gender.MALE);
        Person satya = new Person("Satya", Gender.FEMALE);

        kingShah.setSpouse(queenAnga).addChild(ish).addChild(satya);

        assertThat(brother.getFor(satya).size(), IsEqual.equalTo(1));
    }
}