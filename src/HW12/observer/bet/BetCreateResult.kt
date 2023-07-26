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
        fun logBetCreateResult(betCreateResult: BetCreateResult) {
            when (betCreateResult) {
                VALUE_OUT_OF_RANGE -> println("logBetCreateResult: It's impossible to place a bet on this value")
                LOW_BALANCE -> println("logBetCreateResult: There aren't enough balance to place a bet")
                INVALID_BET_AMOUNT -> println("logBetCreateResult: betAmount has invalid value")
                OK -> println("logBetCreateResult: Bet was successfully created")
            }
        }
    }
}