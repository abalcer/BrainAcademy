package com.brainacademy.security;

import java.security.GeneralSecurityException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;

import javax.crypto.Cipher;

public class AsymmetricEncryption {
    private static PrivateKey PRIVATE_KEY;
    private static PublicKey PUBLIC_KEY;

    static {
        KeyPairGenerator keyGenerator = null;
        try {
            keyGenerator = KeyPairGenerator.getInstance("RSA");
            keyGenerator.initialize(1024);
            KeyPair keyPair = keyGenerator.generateKeyPair();
            PUBLIC_KEY = keyPair.getPublic();
            PRIVATE_KEY = keyPair.getPrivate();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    public byte[] encrypt(String message) {
        byte[] data = message.getBytes();
        try {
            Cipher cipher = Cipher.getInstance("RSA");
            cipher.init(Cipher.ENCRYPT_MODE, PUBLIC_KEY);
            return cipher.doFinal(data);
        } catch (GeneralSecurityException e) {
            e.printStackTrace();
            return null;
        }
    }

    public byte[] decrypt(byte[] encryptedData) {
        try {
            Cipher cipher = Cipher.getInstance("RSA");
            cipher.init(Cipher.DECRYPT_MODE, PRIVATE_KEY);
            return cipher.doFinal(encryptedData);
        } catch (GeneralSecurityException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void main(String[] args) {
        AsymmetricEncryption symmetricEncryption = new AsymmetricEncryption();
        byte[] encryptData = symmetricEncryption.encrypt("Hello");
        System.out.println(new String(encryptData));

        byte[] messageData = symmetricEncryption.decrypt(encryptData);
        System.out.println(new String(messageData));
    }
}
