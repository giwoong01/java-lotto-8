package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LottoTest {

    @DisplayName("유효한 로또 번호로 객체를 정상 생성합니다.")
    @Test
    void 로또_번호_정상_생성() {
        // given
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);

        // when & then
        assertDoesNotThrow(() -> new Lotto(numbers));
    }

    @DisplayName("로또 번호의 개수가 6개가 아니면 예외가 발생합니다.")
    @Test
    void 로또_번호의_개수가_6개가_넘어가면_예외_발생() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생합니다.")
    @Test
    void 로또_번호에_중복된_숫자가_있으면_예외_발생() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호가 1 ~ 45 범위를 벗어나면 예외가 발생합니다.")
    @ParameterizedTest
    @ValueSource(ints = {0, 46})
    void 로또_번호_범위_벗어나면_예외_발생(int outOfRangeNumber) {
        // given
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, outOfRangeNumber);

        // when & then
        assertThatThrownBy(() -> new Lotto(numbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("continas() 메소드가 특정 번호의 포함 여부를 정상 반환합니다.")
    @Test
    void contains_메소드_특정_번호_포함_여부_정상_반환() {
        // given
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));

        // when & then
        assertThat(lotto.contains(3)).isTrue();
        assertThat(lotto.contains(11)).isFalse();
    }

    @DisplayName("countMatchingNumbers() 메소드가 당첨 번호와 일치하는 개수를 정상 반환합니다.")
    @Test
    void countMatchingNumbers_메소드_당첨_번호_일치_개수_정상_반환() {
        // given
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        WinningNumbers winningNumbers = new WinningNumbers("1,2,3,11,12,13");

        // when
        int matchCount = lotto.countMatchingNumbers(winningNumbers);

        // then
        assertThat(matchCount).isEqualTo(3);
    }

}
