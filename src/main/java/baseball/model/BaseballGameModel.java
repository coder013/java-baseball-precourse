package baseball.model;

import baseball.enums.NumberRangeEnum;
import nextstep.utils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class BaseballGameModel {

    private final List<Integer> randomValueList = new ArrayList<>();

    public void setRandomValueList() {
        for (int i = 0; i < 3; i++) {
            randomValueList.add(getRandomValue(randomValueList));
        }
    }
    // 서로 다른 수로 이루어진 3자리 수 생성

    private int getRandomValue(List<Integer> list) {
        int randomValue = getRandomValue();

        return list.contains(randomValue) ? getRandomValue(list) : randomValue;
    }
    // 재귀함수, 가져온 숫자가 중복된 숫자일 경우 다시 실행

    private int getRandomValue() {
        return Randoms.pickNumberInRange(NumberRangeEnum.START_NUMBER.getNumber(), NumberRangeEnum.END_NUMBER.getNumber());
    }
}
