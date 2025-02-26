package DSA;
import java.security.*;
import java.io.*;
import java.util.Base64;

public class KeyGenerator {

    public static void main(String[] args) {
        try {
            // Generate DSA Key Pair
            KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("DSA");
            keyPairGenerator.initialize(1024); // 1024-bit DSA key size
            KeyPair keyPair = keyPairGenerator.generateKeyPair();

            // Get private and public keys
            PrivateKey privateKey = keyPair.getPrivate();
            PublicKey publicKey = keyPair.getPublic();

            // Convert private key to PEM format with line breaks every 64 characters
            String privateKeyPEM = "-----BEGIN DSA PRIVATE KEY-----\n" +
                    chunkBase64(Base64.getEncoder().encodeToString(privateKey.getEncoded())) +
                    "\n-----END DSA PRIVATE KEY-----";

            // Save private key to file in PEM format
            try (BufferedWriter privateKeyWriter = new BufferedWriter(new FileWriter("privateKey.key"))) {
                privateKeyWriter.write(privateKeyPEM);
            }

            // Convert public key to PEM format with line breaks every 64 characters
            String publicKeyPEM = "-----BEGIN PUBLIC KEY-----\n" +
                    chunkBase64(Base64.getEncoder().encodeToString(publicKey.getEncoded())) +
                    "\n-----END PUBLIC KEY-----";

            // Save public key to file in PEM format
            try (BufferedWriter publicKeyWriter = new BufferedWriter(new FileWriter("publicKey.key"))) {
                publicKeyWriter.write(publicKeyPEM);
            }

            // Professional Output Response
            System.out.println("---------------------------------");
            System.out.println("Key Pair Generation Report");
            System.out.println("---------------------------------");
            System.out.println("Private Key: privateKey.key (saved successfully in PEM format)");
            System.out.println("Public Key: publicKey.key (saved successfully in PEM format)");
            System.out.println("Generation Status: SUCCESS");
            System.out.println("Action: Keys have been generated and saved securely.");
            System.out.println("---------------------------------");

        } catch (Exception e) {
            System.out.println("An error occurred during key generation.");
            e.printStackTrace();
        }
    }

    // Method to chunk Base64 string every 64 characters and add a newline
    private static String chunkBase64(String base64) {
        StringBuilder chunkedBase64 = new StringBuilder();
        int chunkSize = 64; // Each chunk will have 64 characters
        for (int i = 0; i < base64.length(); i += chunkSize) {
            int end = Math.min(i + chunkSize, base64.length());
            chunkedBase64.append(base64, i, end).append("\n");
        }
        return chunkedBase64.toString();
    }
}
