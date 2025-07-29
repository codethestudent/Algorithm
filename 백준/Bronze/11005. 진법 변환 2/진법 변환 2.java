import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int[] inputs = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            int N = inputs[0];
            int B = inputs[1];

            StringBuilder sb = new StringBuilder();
            while (N > 0) {
                int remain = N % B;
                if (remain < 10) {
                    sb.append((char) ('0' + remain));
                } else {
                    sb.append((char) ('A' + (remain - 10)));
                }
                N = N / B;
            }

            System.out.println(sb.reverse());
        }
    }

}
