package ru.otus.classes

import ru.otus.interfaces.Atm
import spock.lang.Specification

/**
 * {@code AtmSpec} class is a specification of Atm interface.
 */
class AtmSpec extends Specification {

    Atm atm
    static final Integer DEFAULT_AMOUNT = 10

    void setup() {
        atm = new CashBuilder()
            .banknote(Denominations.HUNDRED.value, DEFAULT_AMOUNT)
            .banknote(Denominations.FIFTY.value, DEFAULT_AMOUNT)
            .banknote(Denominations.TWENTY.value, DEFAULT_AMOUNT)
            .banknote(Denominations.TEN.value, DEFAULT_AMOUNT)
            .banknote(Denominations.FIVE.value, DEFAULT_AMOUNT)
            .build()
        assert atm != null
        assert atm.cashTotal == 1850
    }

    def "Withdraw operation reduces total cash in this ATM to a given amount"() {
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

    def "amount requested for withdrawal is given out in smallest number of banknotes"() {
        when:
        SortedMap<Integer, Integer> cash = atm.withdraw(amount)

        then:
        cash == cashMap

        where:
        amount || cashMap
        300    || [100: 3]
        5      || [5: 1]
        20     || [20: 1]
        35     || [20: 1, 10: 1, 5: 1]
        40     || [20: 2]
        85     || [50: 1, 20: 1, 10: 1, 5: 1]
        295    || [100: 2, 50: 1, 20: 2, 5: 1]
    }
}
