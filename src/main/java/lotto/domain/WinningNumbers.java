package lotto.domain;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import lotto.message.ErrorMessage;

public class WinningNumbers {

    private static final int LOTTO_MIN_NUMBER = 1;
    private static final int LOTTO_MAX_NUMBER = 45;
    private static final int LOTTO_NUMBER_COUNT = 6;
    private static final String DELIMITER = ",";

    private final List<Integer> numbers;

    public WinningNumbers(String input) {
        List<Integer> parsedNumbers = parse(input);
        validate(parsedNumbers);
        this.numbers = parsedNumbers;
    }

    private List<Integer> parse(String input) {
        try {
            return Arrays.stream(input.split(DELIMITER))
                    .map(String::trim)
                    .map(Integer::parseInt)
                    .toList();
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.WINNING_NUMBERS_INVALID_FORMAT.getMessage());
        }
    }

    private void validate(List<Integer> numbers) {
        validateSize(numbers);
        validateRange(numbers);
        validateNoDuplicates(numbers);
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException(ErrorMessage.WINNING_NUMBERS_INVALID_SIZE.getMessage());
        }
    }

    private void validateRange(List<Integer> numbers) {
        boolean isOutOfRange = numbers.stream()
                .anyMatch(number -> number < LOTTO_MIN_NUMBER || number > LOTTO_MAX_NUMBER);
        if (isOutOfRange) {
            throw new IllegalArgumentException(ErrorMessage.WINNING_NUMBERS_INVALID_RANGE.getMessage());
        }
    }

    private void validateNoDuplicates(List<Integer> numbers) {
        if (Set.copyOf(numbers).size() != numbers.size()) {
            throw new IllegalArgumentException(ErrorMessage.WINNING_NUMBERS_DUPLICATE.getMessage());
        }
    }

    public boolean contains(int number) {
        return this.numbers.contains(number);
    }

}
