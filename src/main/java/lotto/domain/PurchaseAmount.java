package lotto.domain;

import lotto.message.ErrorMessage;

public class PurchaseAmount {

    private static final int ZERO = 0;
    private static final int LOTTO_PRICE = 1_000;

    private final int value;

    public PurchaseAmount(String input) {
        int amount = parseToInt(input);
        validateIsPositive(amount);
        validateUnit(amount);
        this.value = amount;
    }

    private int parseToInt(String value) {
        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.PURCHASE_AMOUNT_NOT_A_NUMBER.getMessage());
        }
    }

    private void validateIsPositive(int value) {
        if (value <= ZERO) {
            throw new IllegalArgumentException(ErrorMessage.PURCHASE_AMOUNT_NOT_POSITIVE.getMessage());
        }
    }

    private void validateUnit(int value) {
        if (value % LOTTO_PRICE != ZERO) {
            throw new IllegalArgumentException(ErrorMessage.PURCHASE_AMOUNT_INVALID_UNIT.getMessage());
        }
    }

    public int calculateLottoCount() {
        return value / LOTTO_PRICE;
    }

    public int getValue() {
        return value;
    }

}
