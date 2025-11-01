package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class LottoRankTest {

    @DisplayName("valueOf() 메소드가 일치하는 번호 개수와 보너스 번호 일치 여부에 따라 정상으로 반환합니다.")
    @ParameterizedTest
    @CsvSource({
            "6, false, FIRST",
            "5, true, SECOND",
            "5, false, THIRD",
            "4, false, FOURTH",
            "3, false, FIFTH",
            "2, false, MISS",
            "1, false, MISS",
            "0, false, MISS",
    })
    void valueOf_메소드_일치_번호_개수_보너스_번호_일치_여부_정상_반환(int matchCount, boolean matchBonus, LottoRank lottoRank) {
        // when
        LottoRank result = LottoRank.valueOf(matchCount, matchBonus);

        // then
        assertThat(result).isEqualTo(lottoRank);
    }

}