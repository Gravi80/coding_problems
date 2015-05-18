package com.geektrust.meet_the_family;

import com.geektrust.meet_the_family.helpers.Gender;
import org.hamcrest.core.IsEqual;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

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
    public void shouldReturnAllBrothersOfPerson() {
        Person ish = new Person("Ish", Gender.MALE);
        Person chit = new Person("Chit", Gender.MALE);
        Person satya = new Person("Satya", Gender.FEMALE);

        kingShah.setSpouse(queenAnga).addChild(ish).addChild(chit).addChild(satya);
        List<Person> brothers = ish.getBrothers();

        assertThat(brothers.size(), IsEqual.equalTo(1));
    }

    @Test
    public void shouldReturnSameBrothersCountForTwoBrothers() {
        Person ish = new Person("Ish", Gender.MALE);
        Person chit = new Person("Chit", Gender.MALE);

        kingShah.setSpouse(queenAnga).addChild(ish).addChild(chit);

        assertThat(chit.getBrothers().size(), IsEqual.equalTo(ish.getBrothers().size()));
    }

    @Test
    public void shouldReturnBrotherOfASister() {
        Person ish = new Person("Ish", Gender.MALE);
        Person satya = new Person("Satya", Gender.FEMALE);

        kingShah.setSpouse(queenAnga).addChild(ish).addChild(satya);

        assertThat(satya.getBrothers().size(), IsEqual.equalTo(1));
    }

    @Test
    public void shouldAddSelfAsAHusbandOfHisWife() {
        kingShah.setSpouse(queenAnga);

        assertThat(queenAnga.getSpouse().getName(), IsEqual.equalTo("Shan"));
    }

    @Test
    public void shouldGetAllSister() {
        Person satya = new Person("Satya", Gender.FEMALE);
        Person satya_sister = new Person("Satya Sister", Gender.FEMALE);
        kingShah.addChild(satya).addChild(satya_sister);

        assertThat(satya_sister.getSisters().size(), IsEqual.equalTo(1));
    }

    @Test
    public void shouldReturnSameChildrensForSpouse(){
        Person ish = new Person("Ish", Gender.MALE);

        kingShah.setSpouse(queenAnga).addChild(ish);

        assertThat(queenAnga.getChildrens(), IsEqual.equalTo(kingShah.getChildrens()));
    }

}