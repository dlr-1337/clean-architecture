package br.ifg.urutai.usecase.exception;

public class UserValidationException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public UserValidationException(final String message) {
        super(message);
    }
}
