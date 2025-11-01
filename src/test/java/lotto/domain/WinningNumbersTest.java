package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class WinningNumbersTest {

    @DisplayName("유효한 당첨 번호 정상 생성합니다.")
    @Test
    void 유효한_당첨_번호_정상_생성() {
        // given
        String input = "1,2,3,4,5,6";

        // when & then
        assertDoesNotThrow(() -> new WinningNumbers(input));
    }

    @DisplayName("당첨 번호의 개수가 6개가 아닐 경우 예외가 발생합니다.")
    @Test
    void 당첨_번호_개수_6개_X_예외_발생() {
        // given
        String input = "1,2,3,4,5";

        // when & then
        assertThatThrownBy(() -> new WinningNumbers(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호에 중복된 숫자가 있을 경우 예외가 발생합니다.")
    @Test
    void 당첨_번호_중복_예외_발생() {
        // given
        String input = "1,2,3,4,5,5";

        // when & then
        assertThatThrownBy(() -> new WinningNumbers(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호에 숫자와 쉼표(,) 이외의 문자를 포함할 경우 예외가 발생합니다.")
    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,4,5,a", "1, 2,3 , 4, ,5,6", "1,2,3,4;5,6"})
    void 당첨_번호_숫자_쉼표_이외_문자_예외_발생(String input) {
        // when & then
        assertThatThrownBy(() -> new WinningNumbers(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호가 1~45 범위를 벗어날 경우 예외가 발생합니다.")
    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,4,5,46", "0,1,2,3,4,5"})
    void 당첨_번호_범위_벗어날_경우_예외_발생(String input) {
        // when & then
        assertThatThrownBy(() -> new WinningNumbers(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

}