package ru.otus.hw03

import spock.lang.Specification

/**
 * {@code MyArrayListSpec} test class.
 */
class MyArrayListSpec extends Specification {

    private MyArrayList<Object> myArrayList

    def setup() {
        myArrayList = new MyArrayList<>()
        assert myArrayList != null
    }

    def 'constructed list is MyArrayList.class'() {
        expect:
        myArrayList.class == MyArrayList.class
    }

    def 'throws exception if list capacity is negative value'() {
        when:
        myArrayList = new MyArrayList<>(-1)

        then:
        thrown(IllegalArgumentException)
    }

    def "add() method adds element to end of the list"() {
        when:
        myArrayList.add("one")
        myArrayList.add("two")
        myArrayList.add("three")

        then:
        !myArrayList.isEmpty()
        myArrayList.size() == 3
        myArrayList.get(2) == "three"
    }

    def "get(int index) throws exception if 'index' is out of array boundary"() {
        when:
        myArrayList.add("one")
        myArrayList.add("two")
        myArrayList.add("three")
        myArrayList.get(3)

        then:
        thrown(IndexOutOfBoundsException)
    }

    def "get(int index) returns correct element at specified index"() {
        when:
        myArrayList.add("one")
        myArrayList.add("two")
        myArrayList.add("three")

        then:
        myArrayList.get(0) == "one"
        myArrayList.get(2) == "three"
        myArrayList.get(1) == "two"
    }

    def "array can grow in size when necessary"() {
        setup:
        int arraySize = 50
        for (int i = 0; i < arraySize; i++) {
            myArrayList.add(i)
        }

        expect:
        !myArrayList.isEmpty()
        myArrayList.size() == arraySize
    }

    def "remove(Object o) method removes first occurrence of specified element"() {
        setup:
        myArrayList.add("Alice")
        myArrayList.add("Bob")
        myArrayList.add("Alice")

        when:
        myArrayList.remove("Alice")

        then:
        myArrayList.size() == 2
        myArrayList.toString() == "[Bob, Alice]"
    }

    def "remove(Object o) returns true if element removed successfully"() {
        setup:
        myArrayList.add("Alice")
        myArrayList.add("Bob")
        myArrayList.add("Alice")

        expect:
        myArrayList.remove("Alice")
        myArrayList.size() == 2
        !myArrayList.remove("Tom")
    }
}
