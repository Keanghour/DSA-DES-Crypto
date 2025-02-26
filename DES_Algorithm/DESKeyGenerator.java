package DES;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.util.Base64;

public class DESKeyGenerator {

    public static void main(String[] args) {
        try {
            // Generate DES key
            KeyGenerator keyGenerator = KeyGenerator.getInstance("DES");
            keyGenerator.init(56); // DES key size (56 bits)
            SecretKey secretKey = keyGenerator.generateKey();

            // Encode the key in Base64 to display it
            String encodedKey = Base64.getEncoder().encodeToString(secretKey.getEncoded());
            System.out.println("Generated DES Key: " + encodedKey);

            // Save the key to a file or use it for encryption
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
