package br.ifg.urutai.adapter.idgenerator;

import br.ifg.urutai.usecase.port.IdGenerator;

import java.util.UUID;

public final class UuidGenerator implements IdGenerator {

    @Override
    public String generate() {
        return UUID.randomUUID().toString();
    }
}
