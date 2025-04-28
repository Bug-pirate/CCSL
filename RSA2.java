import java.math.BigInteger;
import java.util.Scanner;

public class RSA2 {
    
    public static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }

    public static void main(String[] args) {

        
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter Two Prime Numbers");
        int p = sc.nextInt();
        int q = sc.nextInt();

        boolean flag = true;

        for(int i=2; i<p; i++){
            if(p%i==0){
                System.out.println("Both numbers are not prime");
                flag = false;
                break;
            }
        }
        for(int j=2; j<q; j++){
            if(q%j==0){
                System.out.println("Both numbers are not prime");
                flag = false;
                break;
            }
        }
    
        if(flag){

            BigInteger n= BigInteger.valueOf(p*q);
    
            int phi = (p-1) * (q-1);
    
            int e = 2;
            while(gcd(e, phi) != 1){
                e++;
            }
            
            BigInteger eBig = BigInteger.valueOf(e);
            BigInteger phiBig = BigInteger.valueOf(phi);
            BigInteger d = eBig.modInverse(phiBig);
            System.out.println("Public Key (e, n): (" + e + ", " + n + ")");
            System.out.println("Private Key (d, n): (" + d + ", " + n + ")");
    
            System.out.println("Enter the message: ");
            int m = sc.nextInt();
            BigInteger mBig = BigInteger.valueOf(m);
    
            BigInteger c = mBig.modPow(eBig, n);
            System.out.println("Ciphertext: " + c);
    
            BigInteger dM = c.modPow(d, n);
            System.out.println("Decrypted Msg: " + dM);
            sc.close();
        }        
    }
}
