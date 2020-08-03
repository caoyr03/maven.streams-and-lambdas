package com.github.curriculeon.anthropoid;

import com.github.curriculeon.tools.RandomUtils;
import com.github.curriculeon.tools.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by leon on 5/1/17.
 *
 * @ATTENTION_TO_STUDENTS You are FORBIDDEN from using loops of any sort within the definition of this class.
 */
public final class PersonFactory {
    public PersonFactory() {
        /** this class is not to be instantiated */
    }

    /**
     * @return a new instance of a person with fields of random values
     */
    public Person createRandomPerson() {
        String name = StringUtils.capitalizeFirstChar(RandomUtils.createString('a', 'e', 5));
        String[] aliases = RandomUtils.createStrings('a', 'z', 3, 5);
        boolean isMale = RandomUtils.createBoolean(50);
        long personalId = System.nanoTime();
        Date birthDate = RandomUtils.createDate(1950, 2010);

        Person randomPerson = new Person(name, isMale, personalId, birthDate, aliases);
        return randomPerson;
    }

    /**
     * Section 8.8
     *
     * @param listSize - number of Person objects to create
     * @return - ArrayList of Person objects
     */
    public List<Person> createPersonList(int listSize) {
        List<Person> personList = Arrays.asList(new Person[listSize]); //define an array to initialize with size
        personList = personList.stream().map(p -> createRandomPerson()).collect(Collectors.toList());
        return personList;
    }


    /**
     * @param arrayLength - number of Person objects to create
     * @return - Array of Person objects
     */
    public Person[] createPersonArray(int arrayLength) {
        Person[] personArray = new Person[arrayLength];
        return Arrays.stream(personArray).map(p -> createRandomPerson()).toArray(Person[]::new); //a new Person[]
    }


    /**
     * Section 8.2
     *
     * @param streamCount - number of Person objects to create
     * @return - Stream representation of collection of Person objects
     */
    public Stream<Person> createPersonStream(int streamCount) {
        Person[] personArray = new Person[streamCount];
        return Stream.of(personArray).map(person -> createRandomPerson());
    }
}
