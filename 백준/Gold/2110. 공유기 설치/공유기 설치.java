import java.io.*;
import java.util.*;

public class Main {
    private static int[] arr;
    private static int N;
    private static int C;

    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {

            int[] NC = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            N = NC[0];
            C = NC[1];

            arr = new int[N];

            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(br.readLine());
            }

            Arrays.sort(arr);

            int lo = 1;
            int hi = arr[N - 1] - arr[0];
            int answer = 0;

            while (lo <= hi) {
                int mid = lo + (hi - lo) / 2;

                if (canInstall(mid)) {
                    answer = mid;
                    lo = mid + 1;
                } else {
                    hi = mid - 1;
                }

            }
            bw.write(String.valueOf(answer));
            bw.flush();
        }
    }

    private static boolean canInstall(int distance) {
        int count = 1;
        int last = arr[0];

        for (int i = 1; i < N; i++) {
            if (arr[i] - last >= distance) {
                count++;
                last = arr[i];

                if (count >= C) {
                    return true;
                }
            }
        }
        return false;
    }
}
