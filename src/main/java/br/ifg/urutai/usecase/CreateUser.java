package br.ifg.urutai.usecase;

import br.ifg.urutai.entity.User;
import br.ifg.urutai.usecase.exception.UserAlreadyExistsException;
import br.ifg.urutai.usecase.port.IdGenerator;
import br.ifg.urutai.usecase.port.PasswordEncoder;
import br.ifg.urutai.usecase.port.UserRepository;
import br.ifg.urutai.usecase.validator.UserValidator;

public final class CreateUser {

    private final UserRepository repository;
    private final PasswordEncoder passwordEncoder;
    private final IdGenerator idGenerator;

    public CreateUser(
        final UserRepository repository,
        final PasswordEncoder passwordEncoder,
        final IdGenerator idGenerator
    ) {
        this.repository = repository;
        this.passwordEncoder = passwordEncoder;
        this.idGenerator = idGenerator;
    }

    public User create(final User user) {
        UserValidator.validateCreateUser(user);
        repository.findByEmail(user.getEmail()).ifPresent(existing -> {
            throw new UserAlreadyExistsException(existing.getEmail());
        });

        User userToSave = User.builder()
            .id(idGenerator.generate())
            .email(user.getEmail())
            .password(passwordEncoder.encode(user.getEmail() + user.getPassword()))
            .lastName(user.getLastName())
            .firstName(user.getFirstName())
            .build();

        return repository.create(userToSave);
    }
}
