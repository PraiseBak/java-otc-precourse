package error;

public enum InputErrorEnum {

    INVALID_USERNAME("유효하지 않은 유저네임입니다."),
    INVALID_RESPONSE("유효하지 않은 대답입니다");

    private final String message;

    InputErrorEnum(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}