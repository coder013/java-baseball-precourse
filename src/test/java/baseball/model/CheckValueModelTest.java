package baseball.model;

import baseball.vo.ResultVo;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("정답 확인에 대한 단위 테스트")
public class CheckValueModelTest {

    private final CheckValueModel checkValueModel;
    private final List<Integer> randomValueList;

    public CheckValueModelTest() {
        checkValueModel = new CheckValueModel();
        randomValueList = new ArrayList<>();

        randomValueList.add(1);
        randomValueList.add(2);
        randomValueList.add(3);
    }

    @Test
    @DisplayName("스트라이크만 있을 경우에 대한 테스트")
    void only_strike_test() {
        List<Integer> inputValueList = new ArrayList<>();

        inputValueList.add(1);
        inputValueList.add(5);
        inputValueList.add(3);

        ResultVo resultVo = checkValueModel.getResult(randomValueList, inputValueList);

        assertThat(resultVo.getStrike()).isEqualTo(2);
        assertThat(resultVo.getBall()).isEqualTo(0);
    }

    @Test
    @DisplayName("볼만 있을 경우에 대한 테스트")
    void only_ball_test() {
        List<Integer> inputValueList = new ArrayList<>();

        inputValueList.add(3);
        inputValueList.add(1);
        inputValueList.add(2);

        ResultVo resultVo = checkValueModel.getResult(randomValueList, inputValueList);

        assertThat(resultVo.getStrike()).isEqualTo(0);
        assertThat(resultVo.getBall()).isEqualTo(3);
    }

    @Test
    @DisplayName("스트라이크와 볼이 함께 있을 경우에 대한 테스트")
    void strike_with_ball_test() {
        List<Integer> inputValueList = new ArrayList<>();

        inputValueList.add(1);
        inputValueList.add(9);
        inputValueList.add(2);

        ResultVo resultVo = checkValueModel.getResult(randomValueList, inputValueList);

        assertThat(resultVo.getStrike()).isEqualTo(1);
        assertThat(resultVo.getBall()).isEqualTo(1);
    }

    @Test
    @DisplayName("3스트라이크에 대한 테스트")
    void three_strike_test() {
        List<Integer> inputValueList = new ArrayList<>();

        inputValueList.add(1);
        inputValueList.add(2);
        inputValueList.add(3);

        ResultVo resultVo = checkValueModel.getResult(randomValueList, inputValueList);

        assertThat(resultVo.getStrike()).isEqualTo(3);
        assertThat(resultVo.getBall()).isEqualTo(0);
    }
}
