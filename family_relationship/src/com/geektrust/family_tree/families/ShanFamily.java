package com.geektrust.family_tree.families;


import com.geektrust.family_tree.Person;
import com.geektrust.family_tree.constants.Gender;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ShanFamily implements Family{

    private Map<String, Person> peopleMap;
    private Person kingShan, queenAnga, ish, chit, vich, satya, ambi, lika, vyan, drita, jaya, vrita, jata, driya, mnu,
            vila, jnki, chika, kpila, lavnya, gru, satvy, asva, savya, krpi, saayan, mina, kriya, misa;

    public ShanFamily() {
        this.peopleMap = new HashMap<>();
    }

    @Override
    public void generatePeople() {
        kingShan = addNewPerson("Shan", Gender.MALE);
        queenAnga = addNewPerson("Anga", Gender.FEMALE);
        ish = addNewPerson("Ish", Gender.MALE);
        chit = addNewPerson("Chit", Gender.MALE);
        vich = addNewPerson("Vich", Gender.MALE);
        satya = addNewPerson("Satya", Gender.FEMALE);
        ambi = addNewPerson("Ambi", Gender.FEMALE);
        lika = addNewPerson("Lika", Gender.FEMALE);
        vyan = addNewPerson("Vyan", Gender.MALE);
        drita = addNewPerson("Drita", Gender.MALE);
        jaya = addNewPerson("Jaya", Gender.FEMALE);
        vrita = addNewPerson("Vrita", Gender.MALE);
        jata = addNewPerson("Jata", Gender.MALE);
        driya = addNewPerson("Driya", Gender.FEMALE);
        mnu = addNewPerson("Mnu", Gender.MALE);

        vila = addNewPerson("Vila", Gender.MALE);
        jnki = addNewPerson("Jnki", Gender.FEMALE);
        chika = addNewPerson("Chika", Gender.FEMALE);
        kpila = addNewPerson("Kpila", Gender.MALE);
        lavnya = addNewPerson("Lavnya", Gender.FEMALE);
        gru = addNewPerson("Gru", Gender.MALE);

        satvy = addNewPerson("Satvy", Gender.FEMALE);
        asva = addNewPerson("Asva", Gender.MALE);
        savya = addNewPerson("Savya", Gender.MALE);
        krpi = addNewPerson("Krpi", Gender.FEMALE);
        saayan = addNewPerson("Saayan", Gender.MALE);
        mina = addNewPerson("Mina", Gender.FEMALE);
        kriya = addNewPerson("Kriya", Gender.MALE);
        misa = addNewPerson("Misa", Gender.MALE);
    }

    @Override
    public ShanFamily associatePeople() {
        if (kingShan == null) return this;
        kingShan.setSpouse(queenAnga).addChild(ish).addChild(chit).addChild(vich).addChild(satya);

        chit.setSpouse(ambi).addChild(drita).addChild(vrita);
        drita.setSpouse(jaya).addChild(jata).addChild(driya);
        driya.setSpouse(mnu);

        vich.setSpouse(lika).addChild(vila).addChild(chika);
        vila.setSpouse(jnki).addChild(lavnya);
        chika.setSpouse(kpila);
        lavnya.setSpouse(gru);

        satya.setSpouse(vyan).addChild(satvy).addChild(savya).addChild(saayan);
        satvy.setSpouse(asva);
        savya.setSpouse(krpi).addChild(kriya);
        saayan.setSpouse(mina).addChild(misa);
        return this;
    }

//    # NOTE: This implementation is done assuming each member will have unique name, as it is in the family tree.
    @Override
    public Person findPersonWithName(String name) {
        return peopleMap.get(name);
    }

    @Override
    public List<Person> femaleMembers() {
        ArrayList<Person> femaleMembers = new ArrayList<>();
        for (Person person : peopleMap.values()) {
            if(person.getGender()==Gender.FEMALE) femaleMembers.add(person);
        }
        return femaleMembers;
    }

    @Override
    public Person getHeadOfFamily() {
        return kingShan;
    }


    private Person addNewPerson(String name,Gender gender){
        Person person = new Person(name,gender);
        peopleMap.put(name, person);
        return person;
    }

}
