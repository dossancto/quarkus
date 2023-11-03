package org.doto.infra.adapters;

import jakarta.inject.Singleton;
import java.util.UUID;
import org.doto.adapters.CryptografyAdapter;
import org.doto.adapters.HashCryptografy;

@Singleton
public class FakeCript implements CryptografyAdapter
{
    @Override
    public byte[] GenenateSalt() {
        return UUID.randomUUID().toString().getBytes();
    }

    @Override
    public HashCryptografy Hash(String password, byte[] salt) {
        var strSalt = new String(salt);
        var pass = password + strSalt;

        return new HashCryptografy(pass, strSalt);
    }

    @Override
    public HashCryptografy HashPassword(String password) {
        return Hash(password, GenenateSalt());
    }

    @Override
    public boolean VerifyPassword(String password, String storedHashedPassword, String storedSalt) {
        byte[] saltBytes = storedSalt.getBytes();
        var hashedPassword = Hash(password, saltBytes).hashedPassword();

        return hashedPassword.equals(storedHashedPassword);
    }
}

