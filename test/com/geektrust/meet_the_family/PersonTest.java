package com.geektrust.meet_the_family;

import com.geektrust.meet_the_family.helpers.Gender;
import com.geektrust.meet_the_family.helpers.Relation;
import org.hamcrest.core.IsEqual;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

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
        Person ish = new Person("Ish",Gender.MALE);
        Person chit = new Person("Chit",Gender.MALE);
        ish.addRelative(Relation.BROTHER, chit);

        assertThat(chit.getAll(Relation.BROTHER).size(), IsEqual.equalTo(ish.getAll(Relation.BROTHER).size()));
    }
}