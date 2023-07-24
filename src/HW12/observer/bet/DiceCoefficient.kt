package HW12.observer.bet

/**
 *
 * DiceCoefficient
 *
 * This class calculates odds for bets
 *
 * @property bookmakerCommission Stores the bookmaker's commission for creating a bet. Used when creating a coefficient
 *
 */

class DiceCoefficient {
    companion object {
        private const val bookmakerCommission = 0.02


        /**
         * Calculates coefficient for a value equal to the sum of the values on two dice
         *
         * @param value Value for which the coefficient is calculated
         */
        fun calculateCoefficientForSumEqual(value: Int): Double = calculateCoefficientForSum(value){ a, b -> a == b }

        /**
         * Calculates coefficient for the sum of the values on two dice less than value
         *
         * @param value Value for which the coefficient is calculated
         */
        fun calculateCoefficientForSumLessThan(value: Int): Double = calculateCoefficientForSum(value){ a, b -> a < b }

        /**
         * Calculates coefficient for the sum of the values on two dice grater than value
         *
         * @param value Value for which the coefficient is calculated
         */
        fun calculateCoefficientForSumGraterThan(value: Int): Double = calculateCoefficientForSum(value){ a, b -> a > b }

        /**
         * Calculates coefficient for getting a certain number on at least one of the two dice
         *
         * @param value Value for which the coefficient is calculated
         */
        fun calculateCoefficientForAppearanceOfNumber(value: Int): Double =
            if (value !in 1..6)
                0.0
            else
                36/11*(1 - bookmakerCommission)

        /**
         * Calculates coefficient for getting two number on the two dice
         *
         * @param value Value for which the coefficient is calculated
         */
        fun calculateCoefficientForAppearanceOfTwoNumbers(firstValue: Int, secondValue: Int): Double =
            if (firstValue !in 1..6 || secondValue !in 1..6)
                0.0
            else
                36/2*(1 - bookmakerCommission)

        /**
         * Calculates coefficient for getting even sum of the values on two dice
         *
         */
        fun calculateCoefficientSumIsEven(): Double = 2*(1 - bookmakerCommission)

        /**
         * Calculates coefficient for sum of values on two dice
         *
         * @param sum Value for which the coefficient is calculated
         * @param comparator function to compare sums
         */
        private fun calculateCoefficientForSum(sum: Int, comparator: (Int, Int) -> Boolean): Double {
            if (sum !in 2..12) return 0.0
            var combinations = 0
            for (i in 1..6) {
                for (j in 1..6) {
                    if (comparator(i+j, sum))
                        combinations++
                }
            }
            val probability = combinations.toDouble() / 36.0
            return if (probability > 0)
                1 / probability * (1 - bookmakerCommission)
                else 0.0
        }
    }
}