package com.geektrust.meet_the_family;

import com.geektrust.meet_the_family.helpers.Gender;
import com.geektrust.meet_the_family.helpers.Relation;
import org.hamcrest.core.IsEqual;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertThat;


public class RelationShipFinderTest {

    private Family shahFamily;

    @Test
    public void shouldReturnPeopleThatCorrespondToTheGivenRelationship() {
        shahFamily = new Family("Shah");
        generateShahFamily();

        RelationShipFinder relationShipFinder = new RelationShipFinder(shahFamily);

        ArrayList<String> expectedNames = new ArrayList<>();
        expectedNames.add("Chit");
        expectedNames.add("Vich");

        List<String> actualBrothersName = relationShipFinder.find(Relation.BROTHER, "Ish");

        assertThat(actualBrothersName, IsEqual.equalTo(expectedNames));
    }



    private void generateShahFamily(){
        Person kingShah = new Person("Shah", Gender.MALE);
        Person queenAnga = new Person("Anga", Gender.FEMALE);
        Person ish = new Person("Ish", Gender.MALE);
        Person chit = new Person("Chit", Gender.MALE);
        Person vich = new Person("Vich", Gender.MALE);
        Person satya = new Person("Satya", Gender.FEMALE);

        kingShah.addRelative(Relation.WIFE,queenAnga);
        queenAnga.addRelative(Relation.HUSBAND, kingShah);
        ish.addRelative(Relation.BROTHER, chit);
        ish.addRelative(Relation.BROTHER, vich);
        ish.addRelative(Relation.SISTER, satya);

        shahFamily.addPerson(kingShah);
        shahFamily.addPerson(queenAnga);
        shahFamily.addPerson(ish);
        shahFamily.addPerson(chit);
        shahFamily.addPerson(vich);
        shahFamily.addPerson(satya);
    }
}