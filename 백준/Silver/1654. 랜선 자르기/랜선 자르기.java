import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int K = arr[0];
            int N = arr[1];

            long[] lanCables = new long[K];
            long hi = 0;

            for (int i = 0; i < K; i++) {
                lanCables[i] = Long.parseLong(br.readLine());
                hi = hi < lanCables[i] ? lanCables[i] : hi;
            }

            long lo = 1;
            long count = 0;
            while (lo <= hi) {
                count = 0;
                long mid = (lo + hi) / 2;

                for (int i = 0; i < K; i++) {
                    count += lanCables[i] / mid;
                    if (count >= N) {
                        break;
                    }
                }

                if (count >= N) {
                    lo = mid + 1;
                } else {
                    hi = mid - 1;
                }
            }

            bw.write(String.valueOf(hi));
            bw.flush();
        }
    }
}
