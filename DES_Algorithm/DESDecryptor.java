package DES_Algorithm;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;

public class DESDecryptor {

    public static void main(String[] args) {
        try {
            // Sample encrypted data (Base64 format)
            String encryptedBase64 = "6jeNS06q85tT44ofEHnK1geGHDE2vjUxkGGiBYTh+zE=";

            // The key must be in Base64 format
            String keyBase64 = "9COJ7Hq8jJg=";

            // Decode the Base64 key to get the SecretKey
            byte[] decodedKey = Base64.getDecoder().decode(keyBase64);
            SecretKey secretKey = new SecretKeySpec(decodedKey, 0, decodedKey.length, "DES");

            // Decode the encrypted data from Base64
            byte[] encryptedData = Base64.getDecoder().decode(encryptedBase64);

            // Decrypt data
            Cipher cipher = Cipher.getInstance("DES");
            cipher.init(Cipher.DECRYPT_MODE, secretKey);
            byte[] decryptedData = cipher.doFinal(encryptedData);

            // Print the decrypted data
            String decryptedString = new String(decryptedData);
            System.out.println("Decrypted Data: " + decryptedString);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
