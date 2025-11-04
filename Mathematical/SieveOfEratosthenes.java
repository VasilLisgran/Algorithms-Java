import java.util.Arrays;
import java.util.Scanner;

public class SieveOfEratosthenes {
    public static Scanner in = new Scanner(System.in);

    static int[] sieve(int n) {

        // creation of boolean array
        boolean[] prime = new boolean[n + 1];
        Arrays.fill(prime, true);
        prime[0] = false;
        prime[1] = false;

        for (int p = 2; p * p <= n; p++) {
            if (prime[p]) {
                // marking as false
                for (int i = p * p; i <= n; i += p)
                    prime[i] = false;
            }
        }

        // Count number of primes
        int count = 0;
        for (int p = 2; p <= n; p++) {
            if (prime[p])
                count++;
        }

        // Store primes in an array
        int[] res = new int[count];
        int index = 0;
        for (int p = 2; p <= n; p++) {
            if (prime[p])
                res[index++] = p;
        }

        return res;
    }

    public static void main(String[] args) {
        int n = in.nextInt();
        int[] res = sieve(n);
        for (int ele : res) {
            System.out.print(ele + " ");
        }
    }
}
