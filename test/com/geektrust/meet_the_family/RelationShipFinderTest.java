package com.geektrust.meet_the_family;

import com.geektrust.meet_the_family.helpers.Gender;
import com.geektrust.meet_the_family.relations.Brother;
import org.hamcrest.core.IsEqual;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertThat;


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

//    @Test
//    public void shouldReturnEmptyListIfInvalidPersonNameIsPassed() {
//        Family shahFamily = TestData.generateShanFamily();
//
//        RelationShipFinder relationShipFinder = new RelationShipFinder(shahFamily);
//        List<String> actualBrothersName = relationShipFinder.find(Relation.BROTHER, "invalid");
//
//        assertTrue(actualBrothersName.isEmpty());
//    }
//
//    @Test
//    public void shouldReturnHusbandOfQueenAnga() {
//        Family shahFamily = TestData.generateShanFamily();
//        RelationShipFinder relationShipFinder = new RelationShipFinder(shahFamily);
//
//        ArrayList<String> expectedName = new ArrayList<>();
//        expectedName.add("Shan");
//
//        List<String> husbandName = relationShipFinder.find(Relation.HUSBAND, "Anga");
//        assertThat(husbandName, IsEqual.equalTo(expectedName));
//    }
//
//    @Test
//    public void shouldReturnSonOfKingShan() {
//        Family shahFamily = TestData.generateShanFamily();
//        RelationShipFinder relationShipFinder = new RelationShipFinder(shahFamily);
//
//        ArrayList<String> expectedNames = new ArrayList<>();
//        expectedNames.add("Ish");
//        expectedNames.add("Chit");
//        expectedNames.add("Vich");
//
//        List<String> sonNames = relationShipFinder.find(Relation.SON, "Shan");
//
//        assertThat(sonNames, IsEqual.equalTo(expectedNames));
//    }
//
//    @Test
//    public void shouldReturnFatherOfChitAndSatya() {
//        Family shahFamily = TestData.generateShanFamily();
//        RelationShipFinder relationShipFinder = new RelationShipFinder(shahFamily);
//
//        ArrayList<String> expectedNames = new ArrayList<>();
//        expectedNames.add("Shan");
//
//        List<String> chitFatherName = relationShipFinder.find(Relation.FATHER, "Chit");
//        List<String> satyaFatherName = relationShipFinder.find(Relation.FATHER, "Satya");
//
//        assertThat(chitFatherName, IsEqual.equalTo(expectedNames));
//        assertThat(satyaFatherName, IsEqual.equalTo(expectedNames));
//    }
//
//    @Test
//    public void shouldReturnMotherOfIshAndSatya() {
//        Family shahFamily = TestData.generateShanFamily();
//        RelationShipFinder relationShipFinder = new RelationShipFinder(shahFamily);
//
//        ArrayList<String> expectedNames = new ArrayList<>();
//        expectedNames.add("Anga");
//
//        List<String> ishMotherName = relationShipFinder.find(Relation.MOTHER, "Ish");
//        List<String> satyaMotherName = relationShipFinder.find(Relation.MOTHER, "Satya");
//
//        assertThat(ishMotherName, IsEqual.equalTo(expectedNames));
//        assertThat(satyaMotherName, IsEqual.equalTo(expectedNames));
//    }
//
//
//    @Test
//    public void shouldReturnDaughterOfKingShan() {
//        Family shahFamily = TestData.generateShanFamily();
//        RelationShipFinder relationShipFinder = new RelationShipFinder(shahFamily);
//
//        ArrayList<String> expectedName = new ArrayList<>();
//        expectedName.add("Satya");
//
//        List<String> daughterName = relationShipFinder.find(Relation.DAUGHTER, "Shan");
//
//        assertThat(daughterName, IsEqual.equalTo(expectedName));
//    }

}