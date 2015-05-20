package com.geektrust.meet_the_family;

import com.geektrust.family_tree.Person;
import com.geektrust.family_tree.RelationShipFinder;
import com.geektrust.family_tree.constants.Gender;
import com.geektrust.family_tree.families.ShanFamily;
import com.geektrust.family_tree.relations.*;
import org.hamcrest.core.IsEqual;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;


public class RelationShipFinderTest {

    ShanFamily family;
    RelationShipFinder relationShipFinder;

    @Before
    public void setUp() throws Exception {
        family = new ShanFamily();
        family.generatePeople();
        family.associatePeople();
        relationShipFinder = new RelationShipFinder();
    }

    @Test
    public void shouldReturnPeopleThatCorrespondToTheGivenRelationship() {
        ArrayList<String> expectedNames = new ArrayList<>();
        expectedNames.add("Chit");
        expectedNames.add("Vich");

        List<String> actualBrothersName = relationShipFinder.find(family.findPersonWithName("Ish"), new Brother());

        assertThat(actualBrothersName, IsEqual.equalTo(expectedNames));
    }

    @Test
    public void shouldReturnEmptyListIfInvalidPersonNameIsPassed() {
        Person invalidPerson = new Person("Shan", Gender.MALE);
        List<String> actualBrothersName = relationShipFinder.find(invalidPerson, new Brother());

        assertTrue(actualBrothersName.isEmpty());
    }

    @Test
    public void shouldReturnHusbandOfQueenAnga() {
        ArrayList<String> expectedName = new ArrayList<>();
        expectedName.add("Shan");

        List<String> husbandName = relationShipFinder.find(family.findPersonWithName("Anga"), new Husband());
        assertThat(husbandName, IsEqual.equalTo(expectedName));
    }

    @Test
    public void shouldReturnSonOfKingShan() {
        ArrayList<String> expectedNames = new ArrayList<>();
        expectedNames.add("Ish");
        expectedNames.add("Chit");
        expectedNames.add("Vich");

        List<String> sonNames = relationShipFinder.find(family.findPersonWithName("Shan"), new Son());

        assertThat(sonNames, IsEqual.equalTo(expectedNames));
    }

    @Test
    public void shouldReturnFatherOfChitAndSatya() {
        ArrayList<String> expectedNames = new ArrayList<>();
        expectedNames.add("Shan");

        List<String> chitFatherName = relationShipFinder.find(family.findPersonWithName("Chit"), new Father());
        List<String> satyaFatherName = relationShipFinder.find(family.findPersonWithName("Satya"), new Father());

        assertThat(chitFatherName, IsEqual.equalTo(expectedNames));
        assertThat(satyaFatherName, IsEqual.equalTo(expectedNames));
    }

    @Test
    public void shouldReturnMotherOfIshAndSatya() {
        ArrayList<String> expectedNames = new ArrayList<>();
        expectedNames.add("Anga");

        List<String> ishMotherName = relationShipFinder.find(family.findPersonWithName("Ish"), new Mother());
        List<String> satyaMotherName = relationShipFinder.find(family.findPersonWithName("Satya"), new Mother());

        assertThat(ishMotherName, IsEqual.equalTo(expectedNames));
        assertThat(satyaMotherName, IsEqual.equalTo(expectedNames));
    }

    @Test
    public void shouldReturnDaughterOfKingShan() {
        ArrayList<String> expectedName = new ArrayList<>();
        expectedName.add("Satya");

        List<String> daughterName = relationShipFinder.find(family.findPersonWithName("Shan"), new Daughter());

        assertThat(daughterName, IsEqual.equalTo(expectedName));
    }

    @Test
    public void shouldReturnGrandChildrenOfJnki() {
        Person vanya = new Person("Vanya", Gender.FEMALE);
        family.findPersonWithName("Lavnya").addChild(vanya);
        ArrayList<String> expectedName = new ArrayList<>();
        expectedName.add("Vanya");

        List<String> grandChildrenName = relationShipFinder.find(family.findPersonWithName("Jnki"), new GrandChildren());

        assertThat(grandChildrenName, IsEqual.equalTo(expectedName));
    }

    @Test
    public void shouldReturnMotherWithTheMostGirlChildren() {
        Set<String> expectedNames = new HashSet<>();
        expectedNames.add("Jaya");
        expectedNames.add("Jnki");
        expectedNames.add("Satya");
        expectedNames.add("Lika");

        Set<String> mothersName = relationShipFinder.getMothersWithMostGirlChild(family);

        assertThat(mothersName, IsEqual.equalTo(expectedNames));
    }

    @Test
    public void shouldReturnJayaAsMotherWithMostGirlChildren() {
        Person drini = new Person("Drini",Gender.FEMALE);
        Person jaya = family.findPersonWithName("Jaya");
        jaya.addChild(drini);

        Set<String> expectedNames = new HashSet<>();
        expectedNames.add("Jaya");

        Set<String> mothersName = relationShipFinder.getMothersWithMostGirlChild(family);

        assertThat(mothersName, IsEqual.equalTo(expectedNames));
    }

}