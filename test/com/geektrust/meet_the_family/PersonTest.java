package com.geektrust.meet_the_family;

import com.geektrust.meet_the_family.helpers.Gender;
import com.geektrust.meet_the_family.helpers.Relation;
import org.hamcrest.core.IsEqual;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertThat;

public class PersonTest {

    @Test
    public void shouldCreateAPersonWithANameAndGender() {
        Person person = new Person("Ravi", Gender.MALE);
        assertThat(person.getName(), IsEqual.equalTo("Ravi"));
    }


    @Test
    public void shouldReturnAllBrothersOfPerson() {
        Person person = new Person("Ravi", Gender.MALE);
        Person brother = new Person("brother", Gender.MALE);
        Person sister = new Person("sister", Gender.FEMALE);
        person.addRelative(Relation.BROTHER, brother);
        person.addRelative(Relation.SISTER, sister);
        List<Person> brothers = person.getAll(Relation.BROTHER);

        assertThat(brothers.size(), IsEqual.equalTo(1));
    }

    @Test
    public void shouldReturnSameBrothersCountForTwoBrothers() {
        Person ish = new Person("Ish", Gender.MALE);
        Person chit = new Person("Chit", Gender.MALE);
        ish.addRelative(Relation.BROTHER, chit).alsoAddSelfAsARelative();

        assertThat(chit.getAll(Relation.BROTHER).size(), IsEqual.equalTo(ish.getAll(Relation.BROTHER).size()));
    }

    @Test
    public void shouldAddSelfAsABrotherOfHisSister() {
        Person ish = new Person("Ish", Gender.MALE);
        Person satya = new Person("Satya", Gender.FEMALE);

        ish.addRelative(Relation.SISTER, satya).alsoAddSelfAsARelative();
        assertThat(satya.getAll(Relation.BROTHER).size(), IsEqual.equalTo(1));
    }

    @Test
    public void shouldAddSelfAsAHusbandOfHisWife() {
        Person kingShah = new Person("Shah", Gender.MALE);
        Person queenAnga = new Person("Anga", Gender.FEMALE);

        kingShah.addRelative(Relation.WIFE, queenAnga).alsoAddSelfAsARelative();

        assertThat(queenAnga.getAll(Relation.HUSBAND).size(), IsEqual.equalTo(1));
    }

    @Test
    public void shouldAddSelfAsSisterOfHerSister() {
        Person satya = new Person("Satya", Gender.FEMALE);
        Person satya_sister = new Person("Satya Sister", Gender.FEMALE);

        satya.addRelative(Relation.SISTER, satya_sister).alsoAddSelfAsARelative();

        assertThat(satya_sister.getAll(Relation.SISTER).size(), IsEqual.equalTo(1));
    }

    @Test
    public void shouldAssociateRelatives(){
        Person kingShah = new Person("Shan", Gender.MALE);
        Person queenAnga = new Person("Anga", Gender.FEMALE);
        Person ish = new Person("Ish", Gender.MALE);

        kingShah.addRelative(Relation.SON, ish).alsoAddSelfAsARelative();
        kingShah.addRelative(Relation.WIFE, queenAnga).alsoAddSelfAsARelative();

        assertThat(queenAnga.getAll(Relation.SON).size(), IsEqual.equalTo(1));
//        assertThat(ish.getAll(Relation.MOTHER).size(), IsEqual.equalTo(1));
    }

}