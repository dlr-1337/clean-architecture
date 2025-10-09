package br.ifg.urutai.usecase;

import br.ifg.urutai.entity.User;
import br.ifg.urutai.usecase.exception.NotAllowedException;
import br.ifg.urutai.usecase.port.PasswordEncoder;
import br.ifg.urutai.usecase.port.UserRepository;

public final class LoginUser {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public LoginUser(
        final UserRepository userRepository,
        final PasswordEncoder passwordEncoder
    ) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public User login(final String email, final String password) {
        User user = userRepository
            .findByEmail(email)
            .orElseThrow(() -> new NotAllowedException("Not allowed"));

        String hashedPassword = passwordEncoder.encode(email + password);
        if (!user.getPassword().equals(hashedPassword)) {
            throw new NotAllowedException("Not allowed");
        }

        return user;
    }
}
