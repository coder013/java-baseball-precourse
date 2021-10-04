package baseball;

import nextstep.utils.Console;
import nextstep.utils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class BaseballGame {
    private final static int startInclusive = 1;
    private final static int endInclusive = 9;

    public void playBaseballGame() {
        try {
            List<Integer> randomValueList = getRandomValueList();

            System.out.printf("%d ~ %d의 서로 다른 수로 이루어진 3자리 숫자를 맞추는 게임입니다.\n", startInclusive, endInclusive);

            int inputValue = getInputValueByInt();
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
    // 재귀함수, 가져온 숫자가 중복된 숫자일 경우 다시 실행

    private int getRandomValue() {
        return Randoms.pickNumberInRange(startInclusive, endInclusive);
    }

    private int getInputValueByInt() {
        String inputValue = "";
        boolean result = false;

        while (!result) {
            System.out.print("숫자를 입력하세요. : ");

            inputValue = getInputValue();
            result = checkValidation(inputValue);
        }

        return Integer.parseInt(inputValue);
    }
    // 사용자가 입력한 숫자를 가져온다.

    private String getInputValue() {
        return Console.readLine();
    }

    private boolean checkValidation(String inputValue) {
        String pattern = "^[1-9]{3}$";

        if (!inputValue.matches(pattern)) {
            System.out.printf("유효하지 않은 숫자입니다. %d ~ %d의 수로 이루어진 3자리 숫자를 입력하세요.\n", startInclusive, endInclusive);
            return false;
        }

        return true;
    }
}