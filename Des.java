import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.util.Base64;
import java.util.Scanner;

public class Des {

    public static void main(String[] args) {
        try {
            // Generate a DES key
            KeyGenerator keyGen = KeyGenerator.getInstance("DES");
            SecretKey secretKey = keyGen.generateKey();

            // Create a DES cipher
            Cipher desCipher = Cipher.getInstance("DES/ECB/PKCS5Padding");

            Scanner sc = new Scanner(System.in);
            System.out.println("Enter the message : ");
            // Encrypt the message
            String message = sc.nextLine();
            sc.close();
            desCipher.init(Cipher.ENCRYPT_MODE, secretKey);
            byte[] encryptedBytes = desCipher.doFinal(message.getBytes());
            String encryptedMessage = Base64.getUrlEncoder().encodeToString(encryptedBytes);
            System.out.println("Encrypted Message: " + encryptedMessage);

            // Decrypt the message
            desCipher.init(Cipher.DECRYPT_MODE, secretKey);
            byte[] decryptedBytes = desCipher.doFinal(Base64.getUrlDecoder().decode(encryptedMessage));
            String decryptedMessage = new String(decryptedBytes);
            System.out.println("Decrypted Message: " + decryptedMessage);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
