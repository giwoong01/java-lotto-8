package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lotto.domain.generator.LottoGenerator;

public class LottoIssuer {

    private final LottoGenerator lottoGenerator;

    public LottoIssuer(LottoGenerator lottoGenerator) {
        this.lottoGenerator = lottoGenerator;
    }

    public Lottos issue(PurchaseAmount purchaseAmount) {
        int lottoCount = purchaseAmount.calculateLottoCount();

        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < lottoCount; i++) {
            lottos.add(generateLotto());
        }

        return new Lottos(lottos);
    }

    private Lotto generateLotto() {
        List<Integer> numbers = lottoGenerator.generate();
        Collections.sort(numbers);
        return new Lotto(numbers);
    }

}
