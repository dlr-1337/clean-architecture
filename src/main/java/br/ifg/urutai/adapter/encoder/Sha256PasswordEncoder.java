package br.ifg.urutai.adapter.encoder;

import br.ifg.urutai.usecase.port.PasswordEncoder;
import org.apache.commons.codec.digest.DigestUtils;

public final class Sha256PasswordEncoder implements PasswordEncoder {

    @Override
    public String encode(final String str) {
        return DigestUtils.sha256Hex(str);
    }
}
