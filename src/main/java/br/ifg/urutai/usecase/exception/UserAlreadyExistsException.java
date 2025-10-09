package br.ifg.urutai.usecase.exception;

public class UserAlreadyExistsException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public UserAlreadyExistsException(final String email) {
        super(email);
    }
}
