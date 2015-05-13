package com.geektrust.meet_the_family.helpers;


public enum Relation {

    HUSBAND {
        @Override
        public Relation getOppositeRelation(Gender personGender) {
            return WIFE;
        }
    },
    WIFE {
        @Override
        public Relation getOppositeRelation(Gender personGender) {
            return HUSBAND;
        }
    },
    BROTHER {
        @Override
        public Relation getOppositeRelation(Gender personGender) {
            return personGender.equals(Gender.MALE) ? BROTHER : SISTER;
        }
    },
    SISTER {
        @Override
        public Relation getOppositeRelation(Gender personGender) {
            return personGender.equals(Gender.MALE) ? BROTHER : SISTER;
        }
    }, SON {
        @Override
        public Relation getOppositeRelation(Gender personGender) {
            return personGender.equals(Gender.MALE) ? FATHER : MOTHER;
        }
    }, DAUGHTER {
        @Override
        public Relation getOppositeRelation(Gender personGender) {
            return personGender.equals(Gender.MALE) ? FATHER : MOTHER;
        }
    }, FATHER {
        @Override
        public Relation getOppositeRelation(Gender personGender) {
            return personGender.equals(Gender.MALE) ? SON : DAUGHTER;
        }
    }, MOTHER {
        @Override
        public Relation getOppositeRelation(Gender personGender) {
            return personGender.equals(Gender.MALE) ? SON : DAUGHTER;
        }
    };

    public abstract Relation getOppositeRelation(Gender personGender);


}
