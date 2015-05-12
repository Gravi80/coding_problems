package com.geektrust.meet_the_family;

import com.geektrust.meet_the_family.helpers.Gender;
import com.geektrust.meet_the_family.helpers.Relation;
import com.geektrust.meet_the_family.test_helper.TestData;
import org.hamcrest.core.IsEqual;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;


public class RelationShipFinderTest {


    @Test
    public void shouldReturnPeopleThatCorrespondToTheGivenRelationship() {
        Family shahFamily = TestData.generateShahFamily();

        RelationShipFinder relationShipFinder = new RelationShipFinder(shahFamily);

        ArrayList<String> expectedNames = new ArrayList<>();
        expectedNames.add("Chit");
        expectedNames.add("Vich");

        List<String> actualBrothersName = relationShipFinder.find(Relation.BROTHER, "Ish");

        assertThat(actualBrothersName, IsEqual.equalTo(expectedNames));
    }

    @Test
    public void shouldReturnEmptyListIfInvalidPersonNameIsPassed() {
        Family shahFamily = TestData.generateShahFamily();

        RelationShipFinder relationShipFinder = new RelationShipFinder(shahFamily);
        List<String> actualBrothersName = relationShipFinder.find(Relation.BROTHER, "invalid");

        assertTrue(actualBrothersName.isEmpty());
    }
}