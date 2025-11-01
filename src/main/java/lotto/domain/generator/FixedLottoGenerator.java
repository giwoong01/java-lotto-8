package lotto.domain.generator;

import java.util.ArrayList;
import java.util.List;

public class FixedLottoGenerator implements LottoGenerator {

    @Override
    public List<Integer> generate() {
        return new ArrayList<>(List.of(1, 2, 3, 4, 5, 6));
    }

}
