package HW12.observer.bet

/**
 * BetCreateResult.
 *
 * @property VALUE_OUT_OF_RANGE bet value is out of range
 * @property LOW_BALANCE A person doesn't have enough balance to create a bet
 * @property INVALID_BET_AMOUNT Incorrect bet amount
 * @property OK The bet has been successfully created, in case of winning, money will be added to the person’s balance
 */
enum class BetCreateResult {
    VALUE_OUT_OF_RANGE,
    LOW_BALANCE,
    INVALID_BET_AMOUNT,
    OK;

    companion object {
        fun logBetCreateResult(vararg betCreateResult: BetCreateResult) {
            betCreateResult.forEach {
                when (it) {
                    VALUE_OUT_OF_RANGE -> println("На данное значение нельзя совершить ставку")
                    LOW_BALANCE -> println("На аккаунте недостаточно средств")
                    INVALID_BET_AMOUNT -> println("Сумма ставки имеет некорректное значение")
                    OK -> println()
                }
            }
        }
    }
}