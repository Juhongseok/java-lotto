package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

import static lotto.resources.ValidationPattern.PATTERN;

public class Seller {
    private static final int UNIT_MONEY = 1000;
    private static final int START_NUMBER = 1;
    private static final int END_NUMBER = 45;
    private static final int NUMBER_COUNT = 6;

    private Seller() {
    }

    public static Seller getInstance() {
        return new Seller();
    }

    public IssuedLotto sellLotto(String money){
        int purchaseMoney = convertStringToInt(money);
        validateUnitAmount(purchaseMoney);
        return IssueLotto(purchaseMoney / UNIT_MONEY);
    }

    private int convertStringToInt(String payment){
        if (PATTERN.canConvert(payment)) {
            return Integer.parseInt(payment);
        }
        throw new IllegalArgumentException("[ERROR] 숫자만 입력해 주시기 바랍니다.");
    }

    private void validateUnitAmount(int purchaseMoney){
        if (purchaseMoney % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1000원 단위로 입력해야 합니다.");
        }
    }

    private IssuedLotto IssueLotto(int sellCount) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < sellCount; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(START_NUMBER, END_NUMBER, NUMBER_COUNT);
            lottos.add(new Lotto(numbers));
        }
        return new IssuedLotto(lottos);
    }
}
