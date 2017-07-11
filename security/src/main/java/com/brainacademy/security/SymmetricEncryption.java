package com.brainacademy.security;

import java.security.GeneralSecurityException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

public class SymmetricEncryption {
    private static SecretKey SECRET_KEY;

    static {
        KeyGenerator keyGenerator = null;
        try {
            keyGenerator = KeyGenerator.getInstance("AES");
            keyGenerator.init(128);
            SECRET_KEY = keyGenerator.generateKey();
        } catch (NoSuchAlgorithmException e) {
           throw new RuntimeException(e);
        }
    }

    public byte[] encrypt(String message) {
        byte[] data = message.getBytes();
        try {
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.ENCRYPT_MODE, SECRET_KEY);
            return cipher.doFinal(data);
        } catch (GeneralSecurityException e) {
            e.printStackTrace();
            return null;
        }
    }

    public byte[] decrypt(byte[] encryptedData) {
        try {
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.DECRYPT_MODE, SECRET_KEY);
            return cipher.doFinal(encryptedData);
        } catch (GeneralSecurityException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void main(String[] args) {
        SymmetricEncryption symmetricEncryption = new SymmetricEncryption();
        byte[] encryptData = symmetricEncryption.encrypt("Hello");
        System.out.println(new String(encryptData));

        byte[] messageData = symmetricEncryption.decrypt(encryptData);
        System.out.println(new String(messageData));
    }
}
