package br.ifg.urutai.usecase;

import br.ifg.urutai.entity.User;
import br.ifg.urutai.usecase.port.UserRepository;

import java.util.List;
import java.util.Optional;

public final class FindUser {

    private final UserRepository repository;

    public FindUser(final UserRepository repository) {
        this.repository = repository;
    }

    public Optional<User> findById(final String id) {
        return repository.findById(id);
    }

    public Optional<User> findByEmail(final String email) {
        return repository.findByEmail(email);
    }

    public List<User> findAllUsers() {
        return repository.findAllUsers();
    }
}
