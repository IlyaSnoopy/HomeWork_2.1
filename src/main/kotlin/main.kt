import kotlin.math.max

const val ERROR_TYPE = -1
const val ERROR_LIMIT = -2

fun main() {
    println(comission("MasterCard", 0, 100_000))
}

fun comission(card: String, previous: Int, amount: Int): Int {
    if (card == "VK Pay" && (previous + amount > 40_000 || amount > 15_000)) return ERROR_LIMIT
    if (previous + amount > 600_000 || amount > 150_000) return ERROR_LIMIT

    return when (card) {
        "Visa" -> max(35, (amount * 0.0075).toInt())
        "Мир" -> max(35, (amount * 0.0075).toInt())
        "MasterCard" -> return when {
            previous >= 75_000 -> (amount * 0.006 + 20).toInt()
            previous < 75_000 && (amount + previous) > 75_000 ->
                (((amount + previous) - 75000) * 0.006 +20).toInt()
            else -> 0
        }
        "VK Pay" -> 0
        else -> ERROR_TYPE
    }
}