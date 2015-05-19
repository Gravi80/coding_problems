package com.geektrust.meet_the_family.relations;

import com.geektrust.meet_the_family.Person;
import com.geektrust.meet_the_family.helpers.Gender;
import org.hamcrest.core.IsEqual;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertThat;


public class SisterTest {

    private Person kingShah;
    private Person queenAnga;
    Relation sister = new Sister();

    @Before
    public void setUp() throws Exception {
        kingShah = new Person("Shan", Gender.MALE);
        queenAnga = new Person("Anga", Gender.FEMALE);

    }

    @Test
    public void shouldGetAllSister() {
        Person satya = new Person("Satya", Gender.FEMALE);
        Person satya_sister = new Person("Satya Sister", Gender.FEMALE);
        kingShah.addChild(satya).addChild(satya_sister);

        assertThat(sister.getFor(satya).size(), IsEqual.equalTo(1));
    }

}