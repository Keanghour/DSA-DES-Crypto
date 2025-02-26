package DSA;
import java.security.*;
import java.io.*;
import java.util.Base64;

public class Encryptor {

    public static void main(String[] args) {
        try {
            // Load the private key from file
            PrivateKey privateKey = DSAAlgorithm.loadPrivateKey("privateKey.key");

            // Data to be signed (encrypted)
            String data = "Hello Testing";

            // Sign the data
            String signature = DSAAlgorithm.signData(privateKey, data);
            System.out.println("Generated Digital Signature: " + signature);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
