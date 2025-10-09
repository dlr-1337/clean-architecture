package br.ifg.urutai.config;

import br.ifg.urutai.adapter.encoder.Sha256PasswordEncoder;
import br.ifg.urutai.adapter.idgenerator.UuidGenerator;
import br.ifg.urutai.adapter.repository.InMemoryUserRepository;
import br.ifg.urutai.usecase.CreateUser;
import br.ifg.urutai.usecase.FindUser;
import br.ifg.urutai.usecase.LoginUser;
import br.ifg.urutai.usecase.port.IdGenerator;
import br.ifg.urutai.usecase.port.PasswordEncoder;
import br.ifg.urutai.usecase.port.UserRepository;

public class ManualConfig {

    private final UserRepository userRepository = new InMemoryUserRepository();
    private final IdGenerator idGenerator = new UuidGenerator();
    private final PasswordEncoder passwordEncoder = new Sha256PasswordEncoder();

    public CreateUser createUser() {
        return new CreateUser(userRepository, passwordEncoder, idGenerator);
    }

    public FindUser findUser() {
        return new FindUser(userRepository);
    }

    public LoginUser loginUser() {
        return new LoginUser(userRepository, passwordEncoder);
    }
}
