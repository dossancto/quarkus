package org.doto.adapters;

public interface CryptografyAdapter {
    byte[] GenenateSalt();
    HashCryptografy Hash(String password, byte[] salt);
    HashCryptografy HashPassword(String password);
    boolean VerifyPassword(String password, String storedHashedPassword, String storedSalt);
}