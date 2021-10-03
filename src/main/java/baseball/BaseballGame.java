package baseball;

import nextstep.utils.Randoms;

public class BaseballGame {

    private final static int minValue = 123;
    private final static int maxValue = 987;

    public void playBaseballGame() {
        try {
            int randomValue = getRandomValue();

            System.out.println("랜덤 값 : " + randomValue);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public int getRandomValue() {
        return Randoms.pickNumberInRange(minValue, maxValue);
    }
}
