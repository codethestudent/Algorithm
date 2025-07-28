import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int N = Integer.parseInt(br.readLine());

            List<Long> answers = new ArrayList<>();
            for (int i = 0; i < N; i++) {
                int[] inputs = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
                answers.add(getGcdSum(inputs));
            }
            answers.stream().forEach(System.out::println);
        }
    }

    private static long getGcdSum(int[] arr) {
        long result = 0;
        for (int i = 1; i < arr[0]; i++) {
            for (int j = i + 1; j <= arr[0]; j++) {
                result += gcd(arr[i], arr[j]);
            }
        }
        return result;
    }

    private static int gcd(int a, int b) {
        while (b > 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}
