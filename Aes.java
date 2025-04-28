import java.util.Base64;
import java.util.Scanner;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

public class Aes {
    

    public static void main(String[] args) {
        try {
            // Generate a AES key
            KeyGenerator keyGen = KeyGenerator.getInstance("AES");
            SecretKey secretKey = keyGen.generateKey();

            // Create a AES cipher
            Cipher aesCipher = Cipher.getInstance("AES/ECB/PKCS5Padding");

            Scanner sc = new Scanner(System.in);
            System.out.println("Enter the message : ");
            // Encrypt the message
            String message = sc.nextLine();
            aesCipher.init(Cipher.ENCRYPT_MODE, secretKey);
            byte[] encryptedBytes = aesCipher.doFinal(message.getBytes());
            String encryptedMessage = Base64.getUrlEncoder().encodeToString(encryptedBytes);
            System.out.println("Encrypted Message: " + encryptedMessage);

            // Decrypt the message
            aesCipher.init(Cipher.DECRYPT_MODE, secretKey);
            byte[] decryptedBytes = aesCipher.doFinal(Base64.getUrlDecoder().decode(encryptedMessage));
            String decryptedMessage = new String(decryptedBytes);
            System.out.println("Decrypted Message: " + decryptedMessage);

        } catch (Exception e) {
            e.printStackTrace();
        }

        
    }
}
