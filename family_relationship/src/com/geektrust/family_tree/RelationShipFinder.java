package com.geektrust.family_tree;


import com.geektrust.family_tree.families.Family;
import com.geektrust.family_tree.relations.Daughter;
import com.geektrust.family_tree.relations.Relation;

import java.util.*;

public class RelationShipFinder {

    public List<String> find(Person person, Relation relation) {
        List<Person> relatives = relation.getFor(person);
        List<String> relativesNames = new ArrayList<>();
        for (Person relative : relatives) {
            relativesNames.add(relative.getName());
        }
        return relativesNames;
    }


    private Map<String, Integer> getMotherAndDaughterCountMapping(Family family) {
        HashMap<String, Integer> motherAndDaughterCountMap = new HashMap<>();
        List<Person> femaleMembers = family.femaleMembers();
        for (Person femaleMember : femaleMembers) {
            motherAndDaughterCountMap.put(femaleMember.getName(), find(femaleMember, new Daughter()).size());
        }
        return motherAndDaughterCountMap;
    }

    public Set<String> getMothersWithMostGirlChild(Family family) {
        HashSet<String> mothersNames = new HashSet<>();
        Map<String, Integer> mothersAndDaughterCountMapping = getMotherAndDaughterCountMapping(family);
        filterHeadOfFamilyWife(family.getHeadOfFamily().getSpouse(), mothersAndDaughterCountMapping);
        Integer maxDaughterCount = getMaxDaughterCount(mothersAndDaughterCountMapping);

        for (Map.Entry<String, Integer> stringIntegerEntry : mothersAndDaughterCountMapping.entrySet()) {
            if (maxDaughterCount != 0 && stringIntegerEntry.getValue().equals(maxDaughterCount))
                mothersNames.add(stringIntegerEntry.getKey());
        }
        return mothersNames;
    }

    private Integer getMaxDaughterCount(Map<String, Integer> mothersAndDaughterCountMapping) {
        Integer maxDaughterCount = 0;
        for (Integer count : mothersAndDaughterCountMapping.values()) {
            if (count > maxDaughterCount) maxDaughterCount = count;
        }
        return maxDaughterCount;
    }

    // since King Shan want to present gifts to his granddaughters and great-granddaughters
    private void filterHeadOfFamilyWife(Person wife, Map<String, Integer> mothersAndDaughterCountMapping) {
        mothersAndDaughterCountMapping.remove(wife.getName());
    }

}
