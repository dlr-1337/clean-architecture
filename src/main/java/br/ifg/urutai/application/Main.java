package br.ifg.urutai.application;

import br.ifg.urutai.config.ManualConfig;
import br.ifg.urutai.entity.User;
import br.ifg.urutai.usecase.CreateUser;
import br.ifg.urutai.usecase.FindUser;
import br.ifg.urutai.usecase.LoginUser;

import java.util.List;
import java.util.Optional;

public final class Main {

    private Main() {
        // utility
    }

    public static void main(final String[] args) {
        ManualConfig config = new ManualConfig();
        CreateUser createUser = config.createUser();
        FindUser findUser = config.findUser();
        LoginUser loginUser = config.loginUser();

        User user = User.builder()
            .email("joao.silva@gmail.com")
            .password("minhasenha")
            .lastName("silva")
            .firstName("joao")
            .build();

        User createdUser = createUser.create(user);
        System.out.println("User created with id " + createdUser.getId());

        Optional<User> foundUser = findUser.findById(createdUser.getId());
        foundUser.ifPresent(value -> System.out.println("Found user with id " + value.getId()));

        List<User> users = findUser.findAllUsers();
        System.out.println("All users: " + users);

        User loggedUser = loginUser.login("joao.silva@gmail.com", "minhasenha");
        System.out.println("Login allowed for " + loggedUser.getEmail());
    }
}
