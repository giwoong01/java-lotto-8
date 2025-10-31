package lotto.domain;

import java.util.Arrays;
import java.util.function.BiPredicate;

public enum LottoRank {

    FIRST(2_000_000_000, "6개 일치", (matchCount, matchBonus) -> matchCount == 6),
    SECOND(30_000_000, "5개 일치, 보너스 볼 일치", (matchCount, matchBonus) -> matchCount == 5 && matchBonus),
    THIRD(1_500_000, "5개 일치", (matchCount, matchBonus) -> matchCount == 5 && !matchBonus),
    FOURTH(50_000, "4개 일치", (matchCount, matchBonus) -> matchCount == 4),
    FIFTH(5_000, "3개 일치", (matchCount, matchBonus) -> matchCount == 3),
    MISS(0, "낙첨", (matchCount, matchBonus) -> true);

    private final int prizeMoney;
    private final String description;
    private final BiPredicate<Integer, Boolean> isMatch;

    LottoRank(int prizeMoney, String description, BiPredicate<Integer, Boolean> isMatch) {
        this.prizeMoney = prizeMoney;
        this.description = description;
        this.isMatch = isMatch;
    }

    public static LottoRank valueOf(int matchCount, boolean matchBonus) {
        return Arrays.stream(values())
                .filter(lottoRank -> lottoRank.isMatch.test(matchCount, matchBonus))
                .findFirst()
                .orElse(MISS);
    }

    public String getDescription() {
        return description;
    }

    public int getPrizeMoney() {
        return prizeMoney;
    }

}
