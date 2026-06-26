import java.util.Scanner;

public class Prime {
    public static Scanner in = new Scanner(System.in);
    static boolean isPrime(long n){
        if (n <= 1) return false;
        if (n <= 3) return true;
        if (n % 2 == 0 || n % 3 == 0) return false;

        // Trial Division
        for (long i = 5; i * i <= n; i += 6) {
            if (n % i == 0 || n % (i + 2) == 0) return false;
        }
        return true;
    }
    public static void main(String[] args){
        int n = in.nextInt();
        if(isPrime(n)){
            System.out.println("Yes");
        }
        else {
            System.out.println("No");
        }
    }
}





