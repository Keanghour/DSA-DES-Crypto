package DSA;
import java.security.*;
import java.io.*;
import java.util.Base64;

public class Decryptor {

    public static void main(String[] args) {
        try {
            // Load the public key from file
            PublicKey publicKey = DSAAlgorithm.loadPublicKey("publicKey.key");

            // Data and signature to be verified
            String data = "Hello Testing"; // Original message
            String signature = "MC0CFDOWw4Wtm7uHNuzM7G5TrGR1M1TVAhUAifW+E9IPjdKfLE5WgggQvmt0Byk="; // Example signature

            // Verify the signature
            boolean isVerified = DSAAlgorithm.verifySignature(publicKey, data, signature);

            // Shorter response based on the verification result
            System.out.println("---------------------------------");
            System.out.println("Signature Status: " + (isVerified ? "TRUE" : "FALSE"));
            System.out
                    .println("Details: " + (isVerified ? "The signature matches the data and the message is authentic."
                            : "The signature does not match the data, indicating possible tampering or a mismatch."));
            System.out.println("Data Integrity: " + (isVerified ? "The data is intact and authentic."
                    : "The data may have been altered or corrupted, authenticity cannot be verified."));
            System.out.println("Action: " + (isVerified ? "Proceed with confidence."
                    : "DO NOT proceed with the data. It should be considered compromised."));
            System.out.println("---------------------------------");

        } catch (Exception e) {
            System.out.println("An error occurred during the signature verification process.");
            e.printStackTrace();
        }
    }
}
