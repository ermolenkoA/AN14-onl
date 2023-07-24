package HW12.observer.bet

/**
 * BetCreateResult.
 *
 * @property VALUE_OUT_OF_RANGE bet value is out of range
 * @property LOW_BALANCE A person doesn't have enough balance to create a bet
 * @property INVALID_VALUE One of the values isn't positive
 * @property OK The bet has been successfully created, in case of winning, money will be added to the person’s balance
 */
enum class BetCreateResult {
    VALUE_OUT_OF_RANGE,
    LOW_BALANCE,
    INVALID_VALUE,
    OK
}