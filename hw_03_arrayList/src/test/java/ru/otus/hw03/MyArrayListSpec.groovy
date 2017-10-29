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

    def 'MyArrayList is not null when constructed'() {
        expect:
        new MyArrayList<>() != null
    }

    def 'constructed list is MyArrayList.class'() {
        expect:
        new MyArrayList<>().class == MyArrayList.class
    }

    def 'throws exception if list capacity is negative value'() {
        when:
        new MyArrayList<>(-1)

        then:
        thrown(IllegalArgumentException)
    }
}
