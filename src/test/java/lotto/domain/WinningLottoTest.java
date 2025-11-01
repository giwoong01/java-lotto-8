package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinningLottoTest {

    private WinningLotto winningLotto;

    @BeforeEach
    void setUp() {
        WinningNumbers winningNumbers = new WinningNumbers("1,2,3,4,5,6");
        BonusNumber bonusNumber = new BonusNumber("7", winningNumbers);
        winningLotto = new WinningLotto(winningNumbers, bonusNumber);
    }

    @DisplayName("determineRank() 메소드가 주어진 로또에 대해 정확한 등수를 반환합니다.")
    @Test
    void determineRank_메소드_주어진_로또_정확한_등수_반환() {
        // given
        Lotto lotto1 = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto lotto2 = new Lotto(List.of(1, 2, 3, 4, 5, 7));
        Lotto lotto3 = new Lotto(List.of(1, 2, 3, 4, 5, 8));
        Lotto lotto4 = new Lotto(List.of(1, 2, 3, 4, 8, 9));
        Lotto lotto5 = new Lotto(List.of(1, 2, 3, 8, 9, 10));
        Lotto lotto6 = new Lotto(List.of(1, 2, 8, 9, 10, 11));

        // when
        LottoRank lottoRankFirst = winningLotto.determineRank(lotto1);
        LottoRank lottoRankSecond = winningLotto.determineRank(lotto2);
        LottoRank lottoRankThird = winningLotto.determineRank(lotto3);
        LottoRank lottoRankFourth = winningLotto.determineRank(lotto4);
        LottoRank lottoRankFifth = winningLotto.determineRank(lotto5);
        LottoRank lottoRankMiss = winningLotto.determineRank(lotto6);

        // then
        assertAll(
                () -> assertThat(lottoRankFirst).isEqualTo(LottoRank.FIRST),
                () -> assertThat(lottoRankSecond).isEqualTo(LottoRank.SECOND),
                () -> assertThat(lottoRankThird).isEqualTo(LottoRank.THIRD),
                () -> assertThat(lottoRankFourth).isEqualTo(LottoRank.FOURTH),
                () -> assertThat(lottoRankFifth).isEqualTo(LottoRank.FIFTH),
                () -> assertThat(lottoRankMiss).isEqualTo(LottoRank.MISS)
        );
    }

}