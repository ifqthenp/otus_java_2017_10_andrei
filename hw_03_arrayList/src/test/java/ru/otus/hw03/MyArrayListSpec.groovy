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
}
