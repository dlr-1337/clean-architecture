package br.ifg.urutai.application;

import br.ifg.urutai.config.ManualConfig;
import br.ifg.urutai.entity.User;
import br.ifg.urutai.usecase.CreateUser;
import br.ifg.urutai.usecase.FindUser;
import br.ifg.urutai.usecase.LoginUser;

import java.util.List;
import java.util.Optional;

public class Main {

    public static void main(final String[] args) {
        // Setup
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

        // Create a user
        User actualCreateUser = createUser.create(user);
        System.out.println("User created with id " + actualCreateUser.getId());

        // Find a user by id
        Optional<User> actualFindUser = findUser.findById(actualCreateUser.getId());
        System.out.println("Found user with id " + actualFindUser.get().getId());

        // List all users
        List<User> users = findUser.findAllUsers();
        System.out.println("List all users: " + users);

        // Login
        loginUser.login("joao.silva@gmail.com", "minhasenha");
        System.out.println("Allowed to Login with email 'joao.silva@gmail.com' and password 'minhasenha'");
    }
}
