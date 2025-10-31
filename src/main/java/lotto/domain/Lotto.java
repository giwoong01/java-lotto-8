package lotto.domain;

import java.util.List;
import java.util.Set;
import lotto.message.ErrorMessage;

public class Lotto {

    private static final int LOTTO_NUMBER_COUNT = 6;

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateNoDuplicates(numbers);
        validateSize(numbers);
        this.numbers = numbers;
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
