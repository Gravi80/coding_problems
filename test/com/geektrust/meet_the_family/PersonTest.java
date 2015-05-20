package com.geektrust.meet_the_family;

import com.geektrust.family_tree.Person;
import com.geektrust.family_tree.constants.Gender;
import org.hamcrest.core.IsEqual;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertThat;

public class PersonTest {

    private Person kingShah;
    private Person queenAnga;

    @Before
    public void setUp() throws Exception {
        kingShah = new Person("Shan", Gender.MALE);
        queenAnga = new Person("Anga", Gender.FEMALE);

    }

    @Test
    public void shouldCreateAPersonWithANameAndGender() {
        Person person = new Person("Ravi", Gender.MALE);
        assertThat(person.getName(), IsEqual.equalTo("Ravi"));
    }


    @Test
    public void shouldAddSelfAsAHusbandOfHisWife() {
        kingShah.setSpouse(queenAnga);

        assertThat(queenAnga.getSpouse().getName(), IsEqual.equalTo("Shan"));
    }

    @Test
    public void shouldReturnSameChildrensForSpouse(){
        Person ish = new Person("Ish", Gender.MALE);

        kingShah.setSpouse(queenAnga).addChild(ish);

        assertThat(queenAnga.getChildrens(), IsEqual.equalTo(kingShah.getChildrens()));
    }

}