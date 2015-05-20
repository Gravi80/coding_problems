package com.geektrust.meet_the_family;

import com.geektrust.meet_the_family.helpers.Gender;
import com.geektrust.meet_the_family.relations.*;
import org.hamcrest.core.IsEqual;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;


public class RelationShipFinderTest {

    ShanFamily family;

    @Before
    public void setUp() throws Exception {
        family = new ShanFamily();
        family.generatePeople();
        family.associatePeople();
    }

    @Test
    public void shouldReturnPeopleThatCorrespondToTheGivenRelationship() {

        RelationShipFinder relationShipFinder = new RelationShipFinder();

        ArrayList<String> expectedNames = new ArrayList<>();
        expectedNames.add("Chit");
        expectedNames.add("Vich");

        List<String> actualBrothersName = relationShipFinder.find(family.findPersonWithName("Ish"), new Brother());

        assertThat(actualBrothersName, IsEqual.equalTo(expectedNames));
    }

    @Test
    public void shouldReturnEmptyListIfInvalidPersonNameIsPassed() {
        Person invalidPerson = new Person("Shan", Gender.MALE);

        RelationShipFinder relationShipFinder = new RelationShipFinder();
        List<String> actualBrothersName = relationShipFinder.find(invalidPerson, new Brother());

        assertTrue(actualBrothersName.isEmpty());
    }

    @Test
    public void shouldReturnHusbandOfQueenAnga() {
        RelationShipFinder relationShipFinder = new RelationShipFinder();

        ArrayList<String> expectedName = new ArrayList<>();
        expectedName.add("Shan");

        List<String> husbandName = relationShipFinder.find(family.findPersonWithName("Anga"), new Husband());
        assertThat(husbandName, IsEqual.equalTo(expectedName));
    }

    @Test
    public void shouldReturnSonOfKingShan() {
        RelationShipFinder relationShipFinder = new RelationShipFinder();

        ArrayList<String> expectedNames = new ArrayList<>();
        expectedNames.add("Ish");
        expectedNames.add("Chit");
        expectedNames.add("Vich");

        List<String> sonNames = relationShipFinder.find(family.findPersonWithName("Shan"), new Son());

        assertThat(sonNames, IsEqual.equalTo(expectedNames));
    }

    @Test
    public void shouldReturnFatherOfChitAndSatya() {
        RelationShipFinder relationShipFinder = new RelationShipFinder();

        ArrayList<String> expectedNames = new ArrayList<>();
        expectedNames.add("Shan");

        List<String> chitFatherName = relationShipFinder.find(family.findPersonWithName("Chit"), new Father());
        List<String> satyaFatherName = relationShipFinder.find(family.findPersonWithName("Satya"), new Father());

        assertThat(chitFatherName, IsEqual.equalTo(expectedNames));
        assertThat(satyaFatherName, IsEqual.equalTo(expectedNames));
    }

    @Test
    public void shouldReturnMotherOfIshAndSatya() {
        RelationShipFinder relationShipFinder = new RelationShipFinder();

        ArrayList<String> expectedNames = new ArrayList<>();
        expectedNames.add("Anga");

        List<String> ishMotherName = relationShipFinder.find(family.findPersonWithName("Ish"), new Mother());
        List<String> satyaMotherName = relationShipFinder.find(family.findPersonWithName("Satya"), new Mother());

        assertThat(ishMotherName, IsEqual.equalTo(expectedNames));
        assertThat(satyaMotherName, IsEqual.equalTo(expectedNames));
    }

    @Test
    public void shouldReturnDaughterOfKingShan() {
        RelationShipFinder relationShipFinder = new RelationShipFinder();

        ArrayList<String> expectedName = new ArrayList<>();
        expectedName.add("Satya");

        List<String> daughterName = relationShipFinder.find(family.findPersonWithName("Shan"), new Daughter());

        assertThat(daughterName, IsEqual.equalTo(expectedName));
    }

    @Test
    public void shouldReturnGrandChildrenOfJnki() {
        Person vanya = new Person("Vanya", Gender.FEMALE);
        family.findPersonWithName("Lavnya").addChild(vanya);
        RelationShipFinder relationShipFinder = new RelationShipFinder();

        ArrayList<String> expectedName = new ArrayList<>();
        expectedName.add("Vanya");

        List<String> daughterName = relationShipFinder.find(family.findPersonWithName("Jnki"), new GrandChildren());

        assertThat(daughterName, IsEqual.equalTo(expectedName));
    }

    @Test
    public void shouldReturnMotherWithTheMostGirlChildren() {
        RelationShipFinder relationShipFinder = new RelationShipFinder();

        ArrayList<String> expectedName = new ArrayList<>();
        expectedName.add("Jaya");
        expectedName.add("Jnki");
        expectedName.add("Satya");
        expectedName.add("Lika");

        List<String> daughterName = relationShipFinder.getMothersWithMostGirlChild();

        assertThat(daughterName, IsEqual.equalTo(expectedName));
    }


}