package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.IssuedLotto;

public class ProjectView {
    public static String askPurchaseMoney(){
        System.out.println("구입금액을 입력해 주세요.");
        return Console.readLine();
    }

    public static void sell(IssuedLotto issuedLotto){
        System.out.println("\n" + issuedLotto.getTotalCount() + "개를 구매했습니다.");
        System.out.println(issuedLotto);
    }
}
