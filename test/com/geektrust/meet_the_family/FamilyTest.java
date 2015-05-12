package com.geektrust.meet_the_family;

import com.geektrust.meet_the_family.test_helper.TestData;
import org.hamcrest.core.IsEqual;
import org.junit.Test;

import static org.junit.Assert.*;


public class FamilyTest {

    @Test
    public void shouldReturnHeadOfFamily(){
        Family shahFamily = TestData.generateShahFamily();
        Person familyHead = shahFamily.getFamilyHead();
        assertThat(familyHead.getName(), IsEqual.equalTo("Shah"));
    }
}