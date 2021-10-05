package baseball.enums;

public enum NumberRangeEnum {
    START_NUMBER(1),
    END_NUMBER(9),
    NUMBER_SIZE(3);

    private final int number;

    NumberRangeEnum(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }
}
