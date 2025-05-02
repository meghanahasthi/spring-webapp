import spock.lang.Specification
import com.example.DerivedData

class OperatorSpec extends Specification {

    def "greater than operator tests"() {
        expect:
        println "attribute: $attribute | attrValue: $attrValue | result: ${greaterThan(attribute, attrValue)}"
        greaterThan(attribute, attrValue) == result

        where:
        attribute | attrValue | result
        "5"       | "10"      | false
        "15"      | "10"      | true
        null      | "10"      | false
        "15"      | null      | false
        "a"       | "10"      | false
        "15"      | "ab"      | false
        "-1"      | "10"      | false
        "15"      | "-1"      | true
        "66666"   | "10"      | true
        "15"      | "66666"   | false
    }

    def "greater than or equal operator tests"() {
        expect:
        println "attribute: $attribute | attrValue: $attrValue | result: ${greaterThanOrEqual(attribute, attrValue)}"
        greaterThanOrEqual(attribute, attrValue) == result

        where:
        attribute | attrValue | result
        "5"       | "10"      | false
        "15"      | "10"      | true
        null      | "10"      | false
        "15"      | null      | false
        "a"       | "10"      | false
        "15"      | "ab"      | false
        "-1"      | "10"      | false
        "15"      | "-1"      | true
        "10"      | "10"      | true
        "-1"      | "-1"      | true
        "2147483647" | "10"   | true
        "-1"      | "999999999" | false
    }

    def "less than operator tests"() {
        expect:
        println "attribute: $attribute | attrValue: $attrValue | result: ${lessThan(attribute, attrValue)}"
        lessThan(attribute, attrValue) == result

        where:
        attribute | attrValue | result
        "5"       | "10"      | true
        "15"      | "10"      | false
        null      | "10"      | false
        "15"      | null      | false
        "a"       | "10"      | false
        "15"      | "ab"      | false
        "-1"      | "10"      | true
        "15"      | "-1"      | false
        "66666"   | "10"      | false
        "15"      | "66666"   | true
    }

    def "less than or equal operator tests"() {
        expect:
        println "attribute: $attribute | attrValue: $attrValue | result: ${lessThanOrEqual(attribute, attrValue)}"
        lessThanOrEqual(attribute, attrValue) == result

        where:
        attribute | attrValue | result
        "5"       | "10"      | true
        "15"      | "10"      | false
        null      | "10"      | false
        "15"      | null      | false
        "a"       | "10"      | false
        "15"      | "ab"      | false
        "-1"      | "10"      | true
        "15"      | "-1"      | false
        "10"      | "10"      | true
        "-1"      | "-1"      | true
        "999999999" | "10"    | false
        "-1"      | "999999999" | true
    }

    def "between operator tests"() {
        expect:
        println "attribute: $attribute | attrValue: $attrValue | result: ${between(attribute, attrValue)}"
        between(attribute, attrValue) == result

        where:
        attribute | attrValue | result
        "5"       | "1 and 10" | true
        "5"       | "6 and 10" | false
        ""        | "1 and 10" | false
        " "       | "1 and 10" | false
        "5"       | ""         | false
        "5"       | "        " | false
        null      | "1 and 10" | false
        "5"       | null       | false
    }

    def "not between operator tests"() {
        expect:
        println "attribute: $attribute | attrValue: $attrValue | result: ${notBetween(attribute, attrValue)}"
        notBetween(attribute, attrValue) == result

        where:
        attribute | attrValue | result
        "5"       | "1 and 10" | false
        "5"       | "6 and 10" | true
        ""        | "1 and 10" | false
        " "       | "1 and 10" | false
        "5"       | ""         | false
        "5"       | "        " | false
        null      | "1 and 10" | false
        "5"       | null       | false
    }

    def "in operator tests"() {
        expect:
        println "attribute: $attribute | attrValue: $attrValue | result: ${in(attribute, attrValue)}"
        in(attribute, attrValue) == result

        where:
        attribute | attrValue | result
        "abc"     | "abc, xyz, pqr" | true
        "abc"     | "a  , xyz, pqr" | false
        ""        | "abc, xyz, pqr" | false
        "   "     | "a  , xyz, pqr" | false
        "abc"     | ""              | false
        "abc"     | "             " | false
        null      | "abc, xyz, pqr" | false
        "abc"     | null            | false
    }
}
