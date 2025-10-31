package lotto.domain;

import lotto.message.ErrorMessage;

public class BonusNumber {

    private static final int LOTTO_MIN_NUMBER = 1;
    private static final int LOTTO_MAX_NUMBER = 45;

    private final int value;

    public BonusNumber(String input, WinningNumbers winningNumbers) {
        int parsedNumber = parseToInt(input);
        validateRange(parsedNumber);
        validateNoDuplicate(parsedNumber, winningNumbers);
        this.value = parsedNumber;
    }

    private int parseToInt(String input) {
        try {
            return Integer.parseInt(input.trim());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.BONUS_NUMBER_INVALID_FORMAT.getMessage());
        }
    }

    private void validateRange(int number) {
        if (number < LOTTO_MIN_NUMBER || number > LOTTO_MAX_NUMBER) {
            throw new IllegalArgumentException(ErrorMessage.BONUS_NUMBER_INVALID_RANGE.getMessage());
        }
    }

    private void validateNoDuplicate(int number, WinningNumbers winningNumbers) {
        if (winningNumbers.contains(number)) {
            throw new IllegalArgumentException(ErrorMessage.BONUS_NUMBER_DUPLICATE.getMessage());
        }
    }

    public int getValue() {
        return value;
    }
    
}