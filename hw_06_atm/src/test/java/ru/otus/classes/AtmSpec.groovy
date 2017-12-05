package ru.otus.classes

import ru.otus.interfaces.Atm
import spock.lang.Specification

/**
 * {@code CashMachineSpec} class.
 */
class CashMachineSpec extends Specification {

    Atm atm

    void setup() {
        atm = new CashBuilder().ten().hundred().twenty().five().fifty().build()
        assert atm != null
        assert atm.cashTotal == 1850
    }

    def "Withdraw operation reduces total cash to a given amount"() {
        when:
        atm.withdraw(200)

        then:
        atm.cashTotal == 1650
    }

    def "cash withdrawal operation throws an exception if amount requested is illegal"() {
        when:
        atm.withdraw(incorrectAmount)

        then:
        thrown(exception)

        where:
        incorrectAmount || exception
        301             || IllegalArgumentException
        134             || IllegalArgumentException
        4               || IllegalArgumentException
        -1              || IllegalArgumentException
    }
}
