package lotto.domain.generator;

import java.util.List;

@FunctionalInterface
public interface LottoGenerator {

    List<Integer> generate();

}
