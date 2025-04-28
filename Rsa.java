import java.math.BigInteger;
import java.security.SecureRandom;

public class Rsa {
    private BigInteger n, d, e;
    private int bitlen = 1024; // Key size

    public Rsa() {
        SecureRandom r = new SecureRandom();
        BigInteger p = BigInteger.probablePrime(bitlen / 2, r);
        BigInteger q = BigInteger.probablePrime(bitlen / 2, r);
        n = p.multiply(q);
        BigInteger phi = (p.subtract(BigInteger.ONE)).multiply(q.subtract(BigInteger.ONE));
        e = new BigInteger("65537"); // Commonly used prime exponent
        d = e.modInverse(phi);
    }

    public BigInteger encrypt(BigInteger message) {
        return message.modPow(e, n);
    }

    public BigInteger decrypt(BigInteger encrypted) {
        return encrypted.modPow(d, n);
    }

    public static void main(String[] args) {
        Rsa rsa = new Rsa();
        String plaintext = "Hello, RSA!";
        BigInteger message = new BigInteger(plaintext.getBytes());
        
        BigInteger encrypted = rsa.encrypt(message);
        System.out.println("Encrypted: " + encrypted);
        
        BigInteger decrypted = rsa.decrypt(encrypted);
        System.out.println("Decrypted: " + new String(decrypted.toByteArray()));
    }
}