package africa.semicolon.ewaApp.exceptions;

public class CustomerDoesNotExistException extends BeansAppException{

    public CustomerDoesNotExistException(String message) {
        super(message);
    }
}
