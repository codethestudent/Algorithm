import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int[] input = Arrays.stream(br.readLine().split(" "))
                                .mapToInt(Integer::parseInt).toArray();
            int n = input[0];
            int m = input[1];

            int twoCount = countFactor(n, 2) - countFactor(m, 2) - countFactor(n - m, 2);
            int fiveCount = countFactor(n, 5) - countFactor(m, 5) - countFactor(n - m, 5);

            System.out.println(Math.min(twoCount, fiveCount));
        }
    }

    private static int countFactor(int n, int factor) {
        int count = 0;
        for (long i = factor; i <= n; i *= factor) {
            count += n / i;
        }
        return count;
    }
}
