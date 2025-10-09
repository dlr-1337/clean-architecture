package br.ifg.urutai.usecase.validator;

import br.ifg.urutai.entity.User;
import br.ifg.urutai.usecase.exception.UserValidationException;

public class UserValidator {

    public static void validateCreateUser(final User user) {
        if (user == null) {
            throw new UserValidationException("Usuário não deve ser nulo");
        }
        if (user.getEmail() == null) {
            throw new UserValidationException("Email não deve ser nulo");
        }
        if (user.getFirstName() == null) {
            throw new UserValidationException("Nome (first name) não deve ser nulo");
        }
        if (user.getLastName() == null) {
            throw new UserValidationException("Sobrenome (last name) não deve ser nulo");
        }
    }
}
