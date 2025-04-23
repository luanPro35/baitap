package org.example.Hash.Key;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.security.auth.kerberos.EncryptionKey;
import java.util.Base64;

public class AES implements org.example.Hash.Key.Encryptable {
    private static final String ALGORITHM = "AES";
    private static final String KEY = "123456789";

    public String encrypt(String data) {
        try{
            SecretKey secretKey = generateKey();
            Cipher cipher = Cipher.getInstance(ALGORITHM);
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);
            byte[] encryptedBytes = cipher.doFinal(data.getBytes());
            return Base64.getEncoder().encodeToString(encryptedBytes);
        } catch (Exception e) {
            throw new RuntimeException("Lỗi mã hóa AES", e);
        }
    }

    @Override
    public String decrypt(String data) {
        try {
            SecretKey secretKey = generateKey();
            Cipher cipher = Cipher.getInstance(ALGORITHM);
            cipher.init(Cipher.DECRYPT_MODE, secretKey);
            byte[] decodedBytes = Base64.getDecoder().decode(data);
            byte[] decryptedBytes = cipher.doFinal(decodedBytes);
            return new String(decryptedBytes);
        } catch (Exception e) {
            throw new RuntimeException("Lỗi giải mã AES", e);
        }
    }
}
