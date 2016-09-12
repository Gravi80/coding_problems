package com.geektrust.meet_the_family.families;


import com.geektrust.family_tree.Person;
import com.geektrust.family_tree.families.Family;
import com.geektrust.family_tree.families.ShanFamily;
import org.hamcrest.core.IsEqual;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;

public class ShanFamilyTest {

    Family shanFamily;

    @Before
    public void setUp(){
        shanFamily = new ShanFamily();
    }

    @Test
    public void shouldGenerateShanFamilyMembers(){
        shanFamily.generatePeople();

        assertNotNull(shanFamily.findPersonWithName("Shan"));
        assertNull(shanFamily.findPersonWithName("invalid_person"));
    }

    @Test
    public void shouldAssociateRelationsBetweenFamilyMembers(){
        shanFamily.generatePeople();
        shanFamily.associatePeople();

        Person shan = shanFamily.findPersonWithName("Shan");
        Person anga = shanFamily.findPersonWithName("Anga");

        Person ishFather = shanFamily.findPersonWithName("Ish").getParents().getFather();
        Person ishMother = shanFamily.findPersonWithName("Ish").getParents().getMother();

        assertThat(anga.getSpouse(), IsEqual.equalTo(shan));
        assertThat(ishFather,IsEqual.equalTo(shan));
        assertThat(ishMother,IsEqual.equalTo(anga));
    }

    @Test
    public void shouldReturnHeadOfFamily(){
        shanFamily.generatePeople();

        assertThat(shanFamily.getHeadOfFamily().getName(),IsEqual.equalTo("Shan"));
    }

}