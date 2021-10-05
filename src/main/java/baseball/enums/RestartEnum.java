package baseball.enums;

public enum RestartEnum {
    RESTART(1);

    private final int number;

    RestartEnum(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }
}
