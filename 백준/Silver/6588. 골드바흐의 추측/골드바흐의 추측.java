import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
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

            StringBuilder sb = new StringBuilder();

            while (true) {
                int n = Integer.parseInt(br.readLine());
                if (n == 0)
                    break;
                for (int i = n - 1; i > 0; i--) {
                    if (isPrime[i] && isPrime[n - i]) {
                        sb.append(n)
                                .append(" = ")
                                .append(n - i)
                                .append(" + ")
                                .append(i)
                                .append("\n");
                        break;
                    }
                }
            }
            sb.deleteCharAt(sb.length() - 1);
            System.out.println(sb);
        }
    }
}
