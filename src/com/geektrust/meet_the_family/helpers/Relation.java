package com.geektrust.meet_the_family.helpers;


public enum Relation {
//    BROTHER, WIFE, HUSBAND, MOTHER, SON, DAUGHTER, SISTER;

    HUSBAND{
        @Override
        public Relation getOppositeRelation(Gender recentlyAddedPersonGender) {
            return WIFE;
        }
    },
    WIFE{
        @Override
        public Relation getOppositeRelation(Gender recentlyAddedPersonGender) {
            return HUSBAND;
        }
    },
    BROTHER {
        @Override
        public Relation getOppositeRelation(Gender recentlyAddedPersonGender) {
            return recentlyAddedPersonGender.equals(Gender.MALE) ? BROTHER : SISTER;
        }
    },
    SISTER {
        @Override
        public Relation getOppositeRelation(Gender recentlyAddedPersonGender) {
            return recentlyAddedPersonGender.equals(Gender.FEMALE) ? BROTHER : SISTER;
        }
    };

    public abstract Relation getOppositeRelation(Gender recentlyAddedPersonGender);


}
