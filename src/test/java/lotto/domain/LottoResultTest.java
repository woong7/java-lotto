package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class LottoResultTest {

    @ParameterizedTest
    @CsvSource(value = {"RANK_FIRST:2", "RANK_SECOND:1", "RANK_THIRD:0", "RANK_FOURTH:0",
            "RANK_FIFTH:0"}, delimiter = ':')
    @DisplayName("LottoResult에 값이 추가가 되는가?")
    void Add_Rank_To_Result(LottoRank lottoRank, int value) {
        LottoResult lottoResult = new LottoResult();
        lottoResult.addWinningLotto(LottoRank.RANK_FIRST);
        lottoResult.addWinningLotto(LottoRank.RANK_FIRST);
        lottoResult.addWinningLotto(LottoRank.RANK_SECOND);
        Assertions.assertThat(lottoResult.getResult().get(lottoRank)).isEqualTo(value);
    }

    @Test
    @DisplayName("당첨금 총합을 계산하는 기능")
    void Calculate_Sum_Of_Prize() {
        LottoResult lottoResult = new LottoResult();
        lottoResult.addWinningLotto(LottoRank.RANK_THIRD);
        lottoResult.addWinningLotto(LottoRank.RANK_FOURTH);
        lottoResult.addWinningLotto(LottoRank.RANK_FIFTH);
        Assertions.assertThat(lottoResult.sumOfPrize()).isEqualTo(1555000);
    }
}
