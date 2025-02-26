package DSA;
import java.io.*;
import java.security.*;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;

public class DSAAlgorithm {

    // Load private key from PEM file
    public static PrivateKey loadPrivateKey(String filePath) throws Exception {
        // Read the PEM file content
        String keyContent = new String(java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(filePath)));

        // Remove the "BEGIN" and "END" lines, and extract the Base64 part
        String privateKeyPEM = keyContent.replace("-----BEGIN DSA PRIVATE KEY-----", "")
                .replace("-----END DSA PRIVATE KEY-----", "")
                .replace("\n", "");

        // Decode the Base64 string into byte array
        byte[] encoded = Base64.getDecoder().decode(privateKeyPEM);

        // Use KeyFactory to generate PrivateKey object
        KeyFactory keyFactory = KeyFactory.getInstance("DSA");
        PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(encoded);
        return keyFactory.generatePrivate(keySpec);
    }

    // Load public key from PEM file
    public static PublicKey loadPublicKey(String filePath) throws Exception {
        // Read the PEM file content
        String keyContent = new String(java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(filePath)));

        // Remove the "BEGIN" and "END" lines, and extract the Base64 part
        String publicKeyPEM = keyContent.replace("-----BEGIN PUBLIC KEY-----", "")
                .replace("-----END PUBLIC KEY-----", "")
                .replace("\n", "");

        // Decode the Base64 string into byte array
        byte[] encoded = Base64.getDecoder().decode(publicKeyPEM);

        // Use KeyFactory to generate PublicKey object
        KeyFactory keyFactory = KeyFactory.getInstance("DSA");
        X509EncodedKeySpec keySpec = new X509EncodedKeySpec(encoded);
        return keyFactory.generatePublic(keySpec);
    }

    // Sign data with private key
    public static String signData(PrivateKey privateKey, String data) throws Exception {
        Signature signature = Signature.getInstance("SHA256withDSA");
        signature.initSign(privateKey);
        signature.update(data.getBytes());
        byte[] signedData = signature.sign();
        return Base64.getEncoder().encodeToString(signedData);
    }

    // Verify the data signature with public key
    public static boolean verifySignature(PublicKey publicKey, String data, String signatureStr) throws Exception {
        Signature signature = Signature.getInstance("SHA256withDSA");
        signature.initVerify(publicKey);
        signature.update(data.getBytes());
        byte[] signatureBytes = Base64.getDecoder().decode(signatureStr);
        return signature.verify(signatureBytes);
    }
}
