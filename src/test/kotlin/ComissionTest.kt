import org.junit.Test
import kotlin.test.assertEquals

class ComissionTest {

    @Test
    fun testExceedLimitVKPay() {
        val card = "VK Pay"
        val previous = 0
        val transfer = 16_000

        val result = comission(card, previous, transfer)

        assertEquals(ERROR_LIMIT, result)
    }

    @Test
    fun testExceedLimitMonthlyVKPay() {
        val card = "VK Pay"
        val previous = 35_000
        val transfer = 20_000

        val result = comission(card, previous, transfer)

        assertEquals(ERROR_LIMIT, result)
    }

    @Test
    fun testExceedLimitAnotherCards() {
        val card = "VK Pay"
        val previous = 0
        val transfer = 160_000

        val result = comission(card, previous, transfer)

        assertEquals(ERROR_LIMIT, result)
    }

    @Test
    fun testExceedLimitAnotherCardsMonthly() {
        val card = "VK Pay"
        val previous = 550_000
        val transfer = 100_000

        val result = comission(card, previous, transfer)

        assertEquals(ERROR_LIMIT, result)
    }

    @Test
    fun testVisa() {
        val card = "Visa"
        val previous = 0
        val transfer = 10_000

        val result = comission(card, previous, transfer)

        assertEquals(75, result)
    }

    @Test
    fun testMir() {
        val card = "Мир"
        val previous = 0
        val transfer = 10_000

        val result = comission(card, previous, transfer)

        assertEquals(75, result)
    }

    @Test
    fun testMasterCardLessThan300() {
        val card = "MasterCard"
        val previous = 0
        val transfer = 200

        val result = comission(card, previous, transfer)

        assertEquals(21, result)
    }

    @Test
    fun testMasterCardNoComission() {
        val card = "MasterCard"
        val previous = 10_000
        val transfer = 10_000

        val result = comission(card, previous, transfer)

        assertEquals(0, result)
    }

    @Test
    fun testMasterCardComissionMonthly() {
        val card = "MasterCard"
        val previous = 80_000
        val transfer = 10_000

        val result = comission(card, previous, transfer)

        assertEquals(80, result)
    }

    @Test
    fun testMasterCardComissionDay() {
        val card = "MasterCard"
        val previous = 0
        val transfer = 80_000

        val result = comission(card, previous, transfer)

        assertEquals(50, result)
    }

    @Test
    fun testMasterCardLimit() {
        val card = "MasterCard"
        val previous = 0
        val transfer = 160_000

        val result = comission(card, previous, transfer)

        assertEquals(ERROR_LIMIT, result)
    }

    @Test
    fun testMasterCardLimitMonthly() {
        val card = "MasterCard"
        val previous = 550_000
        val transfer = 100_000

        val result = comission(card, previous, transfer)

        assertEquals(ERROR_LIMIT, result)
    }

    @Test
    fun testMasterVKPayLimit() {
        val card = "VK Pay"
        val previous = 5_000
        val transfer = 5_000

        val result = comission(card, previous, transfer)

        assertEquals(0, result)
    }

    @Test
    fun testWrongType() {
        val card = "UnionPay"
        val previous = 0
        val transfer = 10_000

        val result = comission(card, previous, transfer)

        assertEquals(ERROR_TYPE, result)
    }
}