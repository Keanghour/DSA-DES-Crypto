package DES;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;

public class DESEncryptor {

    public static void main(String[] args) {
        try {
            // Sample data to encrypt
            String data = "Hello, this is a test message.";

            // The key must be in Base64 format
            String keyBase64 = "9COJ7Hq8jJg=";

            // Decode the Base64 key to get the SecretKey
            byte[] decodedKey = Base64.getDecoder().decode(keyBase64);
            SecretKey secretKey = new SecretKeySpec(decodedKey, 0, decodedKey.length, "DES");

            // Encrypt data
            Cipher cipher = Cipher.getInstance("DES");
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);
            byte[] encryptedData = cipher.doFinal(data.getBytes());

            // Encode the encrypted data in Base64 to make it readable
            String encryptedBase64 = Base64.getEncoder().encodeToString(encryptedData);
            System.out.println("Encrypted Data (Base64): " + encryptedBase64);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
