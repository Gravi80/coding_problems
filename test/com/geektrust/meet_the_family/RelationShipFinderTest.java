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
    Person ambi = new Person("Ambi", Gender.FEMALE);
    Person lika = new Person("Lika", Gender.FEMALE);
    Person vyan = new Person("Vyan", Gender.MALE);
    Person drita = new Person("Drita", Gender.MALE);
    Person jaya = new Person("Jaya", Gender.FEMALE);
    Person vrita = new Person("Vrita", Gender.MALE);
    Person jata = new Person("Jata", Gender.MALE);
    Person driya = new Person("Driya", Gender.FEMALE);
    Person mnu = new Person("Mnu", Gender.MALE);

    Person vila = new Person("Vila", Gender.MALE);
    Person jnki = new Person("Jnki", Gender.FEMALE);
    Person chika = new Person("Chika", Gender.FEMALE);
    Person kpila = new Person("Kpila", Gender.MALE);
    Person lavnya = new Person("Lavnya", Gender.FEMALE);
    Person gru = new Person("Gru", Gender.MALE);

    Person satvy = new Person("Satvy", Gender.FEMALE);
    Person asva = new Person("Asva", Gender.MALE);
    Person savya = new Person("Savya", Gender.MALE);
    Person krpi = new Person("Krpi", Gender.FEMALE);
    Person saayan = new Person("Saayan", Gender.MALE);
    Person mina = new Person("Mina", Gender.FEMALE);
    Person kriya = new Person("Kriya", Gender.MALE);
    Person misa = new Person("Misa", Gender.MALE);


    @Before
    public void setUp() throws Exception {
        kingShan.setSpouse(queenAnga).addChild(ish).addChild(chit).addChild(vich).addChild(satya);

        chit.setSpouse(ambi).addChild(drita).addChild(vrita);
        drita.setSpouse(jaya).addChild(jata).addChild(driya);
        driya.setSpouse(mnu);

        vich.setSpouse(lika).addChild(vila).addChild(chika);
        vila.setSpouse(jnki).addChild(lavnya);
        chika.setSpouse(kpila);
        lavnya.setSpouse(gru);

        satya.setSpouse(vyan).addChild(satvy).addChild(savya).addChild(saayan);
        satvy.setSpouse(asva);
        savya.setSpouse(krpi).addChild(kriya);
        saayan.setSpouse(mina).addChild(misa);
    }

    @Test
    public void shouldReturnPeopleThatCorrespondToTheGivenRelationship() {

        RelationShipFinder relationShipFinder = new RelationShipFinder();

        ArrayList<String> expectedNames = new ArrayList<>();
        expectedNames.add("Chit");
        expectedNames.add("Vich");

        List<String> actualBrothersName = relationShipFinder.find(ish, new Brother());

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

        List<String> husbandName = relationShipFinder.find(queenAnga, new Husband());
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
        List<String> satyaFatherName = relationShipFinder.find(satya, new Father());

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

        List<String> daughterName = relationShipFinder.find(kingShan, new Daughter());

        assertThat(daughterName, IsEqual.equalTo(expectedName));
    }

    @Test
    public void shouldReturnGrandChildrenOfJanki() {
        Person vanya = new Person("Vanya",Gender.FEMALE);
        lavnya.addChild(vanya);
        RelationShipFinder relationShipFinder = new RelationShipFinder();

        ArrayList<String> expectedName = new ArrayList<>();
        expectedName.add("Vanya");

        List<String> daughterName = relationShipFinder.find(jnki, new GrandChildren());

        assertThat(daughterName, IsEqual.equalTo(expectedName));
    }


}