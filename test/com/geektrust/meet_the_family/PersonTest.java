package com.geektrust.meet_the_family;

import com.geektrust.meet_the_family.helpers.Gender;
import com.geektrust.meet_the_family.helpers.Relation;
import org.hamcrest.core.IsEqual;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class PersonTest {

    @Test
    public void shouldCreateAPersonWithANameAndGender(){
        Person person = new Person("Ravi", Gender.MALE);
        assertThat(person.getName(), IsEqual.equalTo("Ravi"));
    }

//    @Test
//    public void shouldInitializeRelativesListIfRelationNotPresent() {
//        Person person = new Person("Ravi");
//        Person brother = new Person("brother");
//        person.addRelative(Relation.BROTHER,brother);
//
//        assertThat();
//
//    }

    @Test
    public void shouldReturnAllBrothersOfPerson() {
        Person person = new Person("Ravi",Gender.MALE);
        Person brother = new Person("brother",Gender.MALE);
        Person sister = new Person("sister",Gender.FEMALE);
        person.addRelative(Relation.BROTHER,brother);
        person.addRelative(Relation.SISTER,sister);
        List<Person> brothers = person.getAll(Relation.BROTHER);

        assertThat(brothers.size(),IsEqual.equalTo(1));
    }
}