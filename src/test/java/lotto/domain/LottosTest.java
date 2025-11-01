package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottosTest {

    private WinningLotto winningLotto;

    @BeforeEach
    void setUp() {
        WinningNumbers winningNumbers = new WinningNumbers("1,2,3,4,5,6");
        BonusNumber bonusNumber = new BonusNumber("7", winningNumbers);
        winningLotto = new WinningLotto(winningNumbers, bonusNumber);
    }

    @DisplayName("Lottos 객체를 정상적으로 생성합니다.")
    @Test
    void Lottos_객체_정상_생성() {
        // given
        Lotto lotto1 = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto lotto2 = new Lotto(List.of(8, 9, 10, 11, 12, 13));

        // when
        Lottos lottos = new Lottos(List.of(lotto1, lotto2));

        // then
        assertThat(lottos.getCount()).isEqualTo(2);
    }

    @DisplayName("getLottos()는 수정이 불가한 리스트를 반환합니다.")
    @Test
    void getLottos_수정_불가_리스트_반환() {
        // given
        Lottos lottos = new Lottos(List.of(new Lotto(List.of(1, 2, 3, 4, 5, 6))));
        List<Lotto> unmodifiableLottos = lottos.getLottos();

        // when & then
        assertThatThrownBy(() -> unmodifiableLottos.add(new Lotto(List.of(7, 8, 9, 10, 11, 12))))
                .isInstanceOf(UnsupportedOperationException.class);
    }

    @DisplayName("calculateStatistics() 메소드가 당첨 번호와 일치하는 개수를 정상 반환합니다.")
    @Test
    void calculateStatistics_메소드_당첨_번호_일치_개수_정상_반환() {
        // given
        Lottos lottos = new Lottos(List.of(
                new Lotto(List.of(1, 2, 3, 10, 11, 12)),
                new Lotto(List.of(1, 2, 3, 4, 10, 11)),
                new Lotto(List.of(1, 2, 3, 4, 5, 10)),
                new Lotto(List.of(1, 2, 3, 4, 5, 7)),
                new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                new Lotto(List.of(10, 11, 12, 13, 14, 15))
        ));

        // when
        Map<LottoRank, Integer> statistics = lottos.calculateStatistics(winningLotto);

        // then
        assertThat(statistics)
                .containsEntry(LottoRank.FIRST, 1)
                .containsEntry(LottoRank.SECOND, 1)
                .containsEntry(LottoRank.THIRD, 1)
                .containsEntry(LottoRank.FOURTH, 1)
                .containsEntry(LottoRank.FIFTH, 1)
                .containsEntry(LottoRank.MISS, 1);
    }

}