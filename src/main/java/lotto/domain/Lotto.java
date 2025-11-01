package lotto.domain;

import java.util.List;
import java.util.Set;
import lotto.message.ErrorMessage;

public class Lotto {

    private static final int LOTTO_MIN_NUMBER = 1;
    private static final int LOTTO_MAX_NUMBER = 45;
    private static final int LOTTO_NUMBER_COUNT = 6;

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        validateSize(numbers);
        validateRange(numbers);
        validateNoDuplicates(numbers);
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException(ErrorMessage.LOTTO_INVALID_SIZE.getMessage());
        }
    }

    private void validateNoDuplicates(List<Integer> numbers) {
        if (Set.copyOf(numbers).size() != numbers.size()) {
            throw new IllegalArgumentException(ErrorMessage.WINNING_NUMBERS_DUPLICATE.getMessage());
        }
    }

    private void validateRange(List<Integer> numbers) {
        boolean isOutOfRange = numbers.stream()
                .anyMatch(number -> number < LOTTO_MIN_NUMBER || number > LOTTO_MAX_NUMBER);
        if (isOutOfRange) {
            throw new IllegalArgumentException(ErrorMessage.WINNING_NUMBERS_INVALID_RANGE.getMessage());
        }
    }

    public int countMatchingNumbers(WinningNumbers winningNumbers) {
        return (int) numbers.stream()
                .filter(winningNumbers::contains)
                .count();
    }

    public boolean contains(int bonusNumber) {
        return numbers.contains(bonusNumber);
    }

    public List<Integer> getNumbers() {
        return List.copyOf(numbers);
    }

}
