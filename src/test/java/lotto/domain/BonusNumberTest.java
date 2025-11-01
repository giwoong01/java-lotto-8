package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class BonusNumberTest {

    private WinningNumbers winningNumbers;

    @BeforeEach
    void setUp() {
        winningNumbers = new WinningNumbers("1,2,3,4,5,6");
    }

    @DisplayName("1 ~ 45 사이의 숫자, 당첨 번호와 중복되지 않는 경우 객체를 정상적으로 생성합니다.")
    @Test
    void 유효한_보너스_번호_객체_정상_생성() {
        // given
        String input = "7";

        // when & then
        assertDoesNotThrow(() -> new BonusNumber(input, winningNumbers));
    }

    @DisplayName("보너스 번호가 1 ~ 45 범위를 벗어나는 경우 예외가 발생합니다.")
    @ParameterizedTest
    @ValueSource(strings = {"0", "46"})
    void 보너스_번호_범위_벗어나는_경우_예외_발생(String input) {
        // when & then
        assertThatThrownBy(() -> new BonusNumber(input, winningNumbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호가 이미 당첨 번호에 포함되어 있는 경우 예외가 발생합니다.")
    @Test
    void 보너스_번호_이미_당첨_번호_포함_예외_발생() {
        // given
        String input = "5";

        // when & then
        assertThatThrownBy(() -> new BonusNumber(input, winningNumbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호가 숫자가 아닌 문자나 공백일 경우 예외가 발생합니다.")
    @ParameterizedTest
    @ValueSource(strings = {"a", " "})
    void 보너스_번호_숫자X_문자_공백_예외_발생(String input) {
        // when & then
        assertThatThrownBy(() -> new BonusNumber(input, winningNumbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

}