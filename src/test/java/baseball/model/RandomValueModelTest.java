package baseball.model;

import baseball.enums.NumberRangeEnum;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

@DisplayName("랜덤 값 생성에 대한 단위 테스트")
public class RandomValueModelTest {

    private final RandomValueModel randomValueModel;

    public RandomValueModelTest() {
        randomValueModel = new RandomValueModel();
    }

    @Test
    @DisplayName("생성한 랜덤 값의 유효성에 대한 테스트")
    void does_() {
        List<Integer> randomValueList = randomValueModel.getRandomValueList();
        checkValidation(randomValueList);
        // assertThatIllegalArgumentException().isThrownBy(() -> checkValidation(randomValueList));
        // IllegalArgumentException() 예외처리를 원할 경우
    }

    private void checkValidation(List<Integer> randomValueList) {
        isIllegal(randomValueList);

        for (int randomValue : randomValueList) {
            isIllegal(randomValue);
        }
    }
    private void isIllegal(List<Integer> randomValueList) {
        if (randomValueList.size() > NumberRangeEnum.NUMBER_SIZE.getNumber()) {
            throw new IllegalArgumentException();
        }
    }

    private void isIllegal(int randomValue) {
        if (randomValue < NumberRangeEnum.START_NUMBER.getNumber()) {
            throw new IllegalArgumentException();
        }

        if (randomValue > NumberRangeEnum.END_NUMBER.getNumber()) {
            throw new IllegalArgumentException();
        }
    }
}
