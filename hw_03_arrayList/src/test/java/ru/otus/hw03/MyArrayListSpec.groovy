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

    def "toString() method returns correct string representation of the list"() {
        when:
        myArrayList.add("Alice")
        myArrayList.add("Bob")
        myArrayList.add("Alice")

        then:
        myArrayList.toString() == "[Alice, Bob, Alice]"
    }

    def "contains(Object o) returns true if list holds specified element"() {
        when:
        myArrayList.add("Alice")
        myArrayList.add("Bob")
        myArrayList.add("Bob")
        myArrayList.add(null)
        myArrayList.add("Tom")


        then:
        myArrayList.contains("Alice")
        myArrayList.contains("Bob")
        myArrayList.contains(null)
        !myArrayList.contains("Carl")
    }

    def "indexOf(Object o) method can find an index of specified element"() {
        setup:
        myArrayList.add("Alice")
        myArrayList.add("Bob")
        myArrayList.add("Bob")
        myArrayList.add(null)
        myArrayList.add("Tom")

        expect:
        myArrayList.indexOf(object) == result

        where:
        object  || result
        "Alice" || 0
        "Bob"   || 1
        "Tom"   || 4
        null    || 3
        "Bob"   || 1
        "Carl"  || -1
    }


    def "lastIndexOf(Object o) method can find the index of the last occurrence of the specified element"() {
        setup:
        myArrayList.add("Alice")
        myArrayList.add("Bob")
        myArrayList.add(null)
        myArrayList.add("Bob")
        myArrayList.add(null)
        myArrayList.add("Alice")
        myArrayList.add("Tom")
        myArrayList.add(null)

        expect:
        myArrayList.lastIndexOf(object) == result

        where:
        object  || result
        "Alice" || 5
        "Harry" || -1
        "Bob"   || 3
        "Tom"   || 6
        null    || 7
        "Bob"   || 3
        "Carl"  || -1
    }

    def "clear() method removes all of the elements from the list"() {
        setup:
        myArrayList.add("Alice")
        myArrayList.add("Bob")
        myArrayList.add(null)
        myArrayList.add("Bob")

        when:
        myArrayList.clear()

        then:
        myArrayList.size() == 0
    }

}
