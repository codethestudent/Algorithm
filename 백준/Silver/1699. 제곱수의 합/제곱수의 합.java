import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        dp = new int[N + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0; // 0을 만들기 위한 제곱수의 개수는 0

        // 모든 제곱수에 대해 dp를 갱신
        for (int i = 1; i * i <= N; i++) {
            int square = i * i;
            for (int j = square; j <= N; j++) {
                dp[j] = Math.min(dp[j], dp[j - square] + 1);
            }
        }

        System.out.println(dp[N]);
    }
}
