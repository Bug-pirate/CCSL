import java.math.BigInteger;
import java.util.Scanner;

public class Deffi {

    public static void primitiveRoot(){

    }
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the prime number");
        BigInteger p = sc.nextBigInteger();

        System.out.println("Enter private key for A : ");
        BigInteger a = sc.nextBigInteger();
        System.out.println("Enter private Key for B :");
        BigInteger b = sc.nextBigInteger();

        System.out.println("Enter the Primitive Root G : ");
        BigInteger g = sc.nextBigInteger();

        BigInteger Ya = g.modPow(a, p);
        BigInteger Yb = g.modPow(b, p);

        BigInteger Ka = Yb.modPow(Ya, p);
        BigInteger Kb = Ya.modPow(Yb, p);

        System.out.println("Ka : "+ Ka);
        System.out.println("Kb : " + Kb);

        
    }
}
