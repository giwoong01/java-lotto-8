package lotto.domain;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class Lottos {

    private final List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public Map<LottoRank, Integer> calculateStatistics(WinningLotto winningLotto) {
        Map<LottoRank, Integer> statistics = new EnumMap<>(LottoRank.class);
        for (LottoRank lottoRank : LottoRank.values()) {
            statistics.put(lottoRank, 0);
        }

        for (Lotto lotto : lottos) {
            statistics.merge(winningLotto.determineRank(lotto), 1, Integer::sum);
        }

        return statistics;
    }

    public int getCount() {
        return lottos.size();
    }

    public List<Lotto> getLottos() {
        return List.copyOf(lottos);
    }

}
