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

    Person kingShan = new Person("Shan", Gender.MALE);
    Person queenAnga = new Person("Anga", Gender.FEMALE);
    Person ish = new Person("Ish", Gender.MALE);
    Person chit = new Person("Chit", Gender.MALE);
    Person vich = new Person("Vich", Gender.MALE);
    Person satya = new Person("Satya", Gender.FEMALE);

    @Before
    public void setUp() throws Exception {
        kingShan.setSpouse(queenAnga).addChild(ish).addChild(chit).addChild(vich).addChild(satya);
    }

    @Test
    public void shouldReturnPeopleThatCorrespondToTheGivenRelationship() {

        RelationShipFinder relationShipFinder = new RelationShipFinder();

        ArrayList<String> expectedNames = new ArrayList<>();
        expectedNames.add("Chit");
        expectedNames.add("Vich");

        List<String> actualBrothersName = relationShipFinder.find(ish,new Brother());

        assertThat(actualBrothersName, IsEqual.equalTo(expectedNames));
    }

    @Test
    public void shouldReturnEmptyListIfInvalidPersonNameIsPassed() {
        Person invalidPerson = new Person("Shan", Gender.MALE);

        RelationShipFinder relationShipFinder = new RelationShipFinder();
        List<String> actualBrothersName = relationShipFinder.find(invalidPerson,new Brother());

        assertTrue(actualBrothersName.isEmpty());
    }

    @Test
    public void shouldReturnHusbandOfQueenAnga() {
        RelationShipFinder relationShipFinder = new RelationShipFinder();

        ArrayList<String> expectedName = new ArrayList<>();
        expectedName.add("Shan");

        List<String> husbandName = relationShipFinder.find(queenAnga,new Husband());
        assertThat(husbandName, IsEqual.equalTo(expectedName));
    }

    @Test
    public void shouldReturnSonOfKingShan() {
        RelationShipFinder relationShipFinder = new RelationShipFinder();

        ArrayList<String> expectedNames = new ArrayList<>();
        expectedNames.add("Ish");
        expectedNames.add("Chit");
        expectedNames.add("Vich");

        List<String> sonNames = relationShipFinder.find(kingShan, new Son());

        assertThat(sonNames, IsEqual.equalTo(expectedNames));
    }

    @Test
    public void shouldReturnFatherOfChitAndSatya() {
        RelationShipFinder relationShipFinder = new RelationShipFinder();

        ArrayList<String> expectedNames = new ArrayList<>();
        expectedNames.add("Shan");

        List<String> chitFatherName = relationShipFinder.find(chit, new Father());
        List<String> satyaFatherName = relationShipFinder.find(satya,new Father());

        assertThat(chitFatherName, IsEqual.equalTo(expectedNames));
        assertThat(satyaFatherName, IsEqual.equalTo(expectedNames));
    }

    @Test
    public void shouldReturnMotherOfIshAndSatya() {
        RelationShipFinder relationShipFinder = new RelationShipFinder();

        ArrayList<String> expectedNames = new ArrayList<>();
        expectedNames.add("Anga");

        List<String> ishMotherName = relationShipFinder.find(ish, new Mother());
        List<String> satyaMotherName = relationShipFinder.find(satya, new Mother());

        assertThat(ishMotherName, IsEqual.equalTo(expectedNames));
        assertThat(satyaMotherName, IsEqual.equalTo(expectedNames));
    }

    @Test
    public void shouldReturnDaughterOfKingShan() {
        RelationShipFinder relationShipFinder = new RelationShipFinder();

        ArrayList<String> expectedName = new ArrayList<>();
        expectedName.add("Satya");

        List<String> daughterName = relationShipFinder.find(kingShan,new Daughter());

        assertThat(daughterName, IsEqual.equalTo(expectedName));
    }

}