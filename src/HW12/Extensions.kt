package HW12

fun main() {
    val valueInt: Int = 3
    val valueDouble: Double = 1.00321
    val valueString: String = "Я сказала стартуем"

    println("Число $valueInt - ${if (valueInt.isEven()) "четное" else "нечетное"}")
    println("Дробная часть числа $valueDouble - ${valueDouble.fractionalPart()}}")
    println("Строка $valueString содержит ${valueString.countVowels()} гласных")
}

fun Int.isEven(): Boolean = this % 2 == 0

fun Double.fractionalPart(): Double = this - this.toInt()

fun String.countVowels(): Int {
    val vowels = "aeiouyаяуюоеёэиы"
    return this.filter{
        it.lowercase() in vowels
    }.length
}