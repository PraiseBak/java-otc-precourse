package error;

public class IllegalInputException extends RuntimeException {
    public IllegalInputException(InputErrorEnum errorMessage) {
        super(errorMessage.getMessage());
    }
}