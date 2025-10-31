package lotto.domain;

public class WinningLotto {

    private final WinningNumbers winningNumbers;
    private final BonusNumber bonusNumber;

    public WinningLotto(WinningNumbers winningNumbers, BonusNumber bonusNumber) {
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    public LottoRank determineRank(Lotto lotto) {
        int matchCount = lotto.countMatchingNumbers(winningNumbers);
        boolean matchBonus = lotto.contains(bonusNumber.getValue());
        return LottoRank.valueOf(matchCount, matchBonus);
    }

}
