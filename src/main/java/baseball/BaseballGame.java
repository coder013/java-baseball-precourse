package baseball;

import nextstep.utils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class BaseballGame {
    private final static int startInclusive = 1;
    private final static int endInclusive = 9;

    public void playBaseballGame() {
        try {
            List<Integer> randomValueList = getRandomValueList();

            System.out.println("랜덤 값 : " + randomValueList.get(0) + randomValueList.get(1) + randomValueList.get(2));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private List<Integer> getRandomValueList() {
        List<Integer> randomValueList = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            randomValueList.add(getRandomValue(randomValueList));
        }

        return randomValueList;
    }
    // 서로 다른 수로 이루어진 3자리 수 생성

    private int getRandomValue(List<Integer> list) {
        int randomValue = getRandomValue();

        return list.contains(randomValue) ? getRandomValue(list) : randomValue;
    }
    // 재귀함수, 중복된 수일 경우 다시 실행

    private int getRandomValue() {
        return Randoms.pickNumberInRange(startInclusive, endInclusive);
    }
    // 1~9 사이의 숫자를 가져온다.
}