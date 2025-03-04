# DSA-DES-Crypto
DES (Data Encryption Standard) is a symmetric-key block cipher that encrypts 64-bit data blocks using a 56-bit key through substitution and permutation operations.

DSA (Data Structures & Algorithms) covers key data structures and algorithms in multiple languages, including arrays, linked lists, trees, graphs, sorting, and dynamic programming. Ideal for learning and practice.

---

# DSA Encryption and Signature Verification

This project demonstrates the use of the **Digital Signature Algorithm (DSA)** to perform encryption, signing, and verification of data, as well as key generation. The following Java classes are included in the project:

### 1. **DSAAlgorithm**
   - **Key Loading**: Methods to load **private** and **public** keys from PEM files.
   - **Sign Data**: Signs data using a private key and generates a digital signature.
   - **Verify Signature**: Verifies if a given digital signature matches the data using the public key.

### 2. **Encryptor**
   - **Purpose**: Signs a message using the private key.
   - **How**: Loads the private key from the `"privateKey.key"` file and signs the message `"Hello Testing"`.
   - **Output**: Outputs the generated digital signature in Base64 format.

### 3. **Decryptor**
   - **Purpose**: Verifies the digital signature for the given data using the public key.
   - **How**: Loads the public key from the `"publicKey.key"` file and verifies the signature for the message `"Hello Testing"`.
   - **Output**: Prints the verification result, indicating whether the signature is valid or not.

### 4. **KeyGenerator**
   - **Purpose**: Generates a **DSA key pair** (private and public keys).
   - **How**: Uses the `KeyPairGenerator` to create a 1024-bit key pair.
   - **Output**: Saves the private and public keys as **PEM-formatted** files (`privateKey.key` and `publicKey.key`).
   - **Additional Features**: Includes a utility method to format the Base64-encoded keys with line breaks.

### 5. **DES Encryption & Decryption (DES Algorithm)**  
   - **DESEncryptor**: Encrypts a message using DES and a provided key.
   - **DESDecryptor**: Decrypts the encrypted message using the corresponding DES key.

### **Key Points**:
- **DSA** is used for generating digital signatures to verify the authenticity and integrity of messages.
- The **private key** is used to sign the data, while the **public key** is used to verify the signature.
- Keys are stored in **PEM** format, which is commonly used for cryptographic keys.
- **DES** (Data Encryption Standard) is implemented to demonstrate symmetric encryption/decryption.

---

### **How to Use**:

1. **Key Generation**:
   - Run `KeyGenerator.java` to generate and save the DSA key pair (`privateKey.key` and `publicKey.key`).
   
2. **Encryption**:
   - Run `Encryptor.java` to sign data using the private key. The signature will be printed.
   
3. **Decryption/Verification**:
   - Run `Decryptor.java` to verify the data's signature using the public key.

4. **DES Encryption/Decryption**:
   - Run `DESEncryptor.java` to encrypt data and `DESDecryptor.java` to decrypt it using the provided keys.

---

### **Notes**:
- Make sure the paths to the PEM files (e.g., `privateKey.key` and `publicKey.key`) are correct.
- The DES key is Base64-encoded and used for encryption/decryption in both `DESEncryptor` and `DESDecryptor`.
- The DSA keys are **1024-bit** for demonstration but can be adjusted based on the security requirements.

---

## Contact

Feel free to reach out if you have any questions or need further assistance:

- **Email**: [phokeanghour12@gmail.com](mailto:phokeanghour12@gmail.com)
- **Telegram**: [@phokeanghour](https://t.me/phokeanghour)

[![Telegram](https://www.vectorlogo.zone/logos/telegram/telegram-ar21.svg)](https://t.me/phokeanghour)
[![LinkedIn](https://www.vectorlogo.zone/logos/linkedin/linkedin-ar21.svg)](https://www.linkedin.com/in/pho-keanghour-27133b21b/)

---

**Credit**: This project was created by **Pho Keanghour**.

---

Let me know if this works or if you'd like any more adjustments!
