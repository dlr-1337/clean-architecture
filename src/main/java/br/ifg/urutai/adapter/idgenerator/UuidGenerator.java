package br.ifg.urutai.adapter.idgenerator;

import br.ifg.urutai.usecase.port.IdGenerator;

import java.util.UUID;

public class UuidGenerator implements IdGenerator {

    @Override
    public String generate() {
        return UUID.randomUUID().toString();
    }
}
