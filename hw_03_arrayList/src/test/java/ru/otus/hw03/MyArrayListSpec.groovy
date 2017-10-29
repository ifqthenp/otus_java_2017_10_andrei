package ru.otus.hw03

import spock.lang.Specification

/**
 * {@code MyArrayListSpec} test class.
 */
class MyArrayListSpec extends Specification {

    def 'MyArrayList is not null when constructed'() {
        expect:
        new MyArrayList<>() != null
    }

    def 'constructed list is MyArrayList.class'() {
        expect:
        new MyArrayList<>().class == MyArrayList.class
    }
}
