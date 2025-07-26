import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    // static List<Integer> defaultPrime;
    // static int[] primes = { 2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31 };

    // public static void main(String[] args) throws IOException {
    // defaultPrime = new ArrayList<>();
    // for (int p : primes) {
    // defaultPrime.add(p);
    // }
    // try (BufferedReader br = new BufferedReader(new
    // InputStreamReader(System.in))) {
    // int N = Integer.parseInt(br.readLine());
    // int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(s ->
    // Integer.parseInt(s)).toArray();
    // int answer = 0;
    // for (int a : arr) {
    // if (isPrime(a)) {
    // answer++;
    // }
    // }
    // System.out.println(answer);
    // }
    // }

    // private static boolean isPrime(int a) {
    // for (int i = 0; i < defaultPrime.size(); i++) {
    // if (a == 1) {
    // return false;
    // }
    // if (defaultPrime.contains(a)) {
    // return true;
    // }
    // if (a % defaultPrime.get(i) == 0) {
    // return false;
    // }
    // }
    // return true;
    // }

    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String[] inputs = br.readLine().split(" ");
            int M = Integer.parseInt(inputs[0]);
            int N = Integer.parseInt(inputs[1]);

            boolean[] isPrime = new boolean[1000000];
            Arrays.fill(isPrime, true);

            isPrime[0] = false;
            isPrime[1] = false;

            for (int i = 2; i * i < 1000000; i++) {
                if (isPrime[i]) {
                    for (int j = i * i; j < 1000000; j += i) {
                        isPrime[j] = false;
                    }
                }
            }
            List<Integer> answers = new ArrayList<>();
            for (int i = M; i <= N; i++) {
                if (isPrime[i]) {
                    answers.add(i);
                }
            }

            for (int a : answers) {
                System.out.println(a);
            }
        }

    }
}
