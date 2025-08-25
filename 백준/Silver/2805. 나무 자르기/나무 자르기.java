import java.io.*;
import java.util.Arrays;

public class Main {
    private static Integer[] trees;

    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {

            int[] NM = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            trees = Arrays.stream(br.readLine().split(" ")).map(Integer::parseInt).toArray(Integer[]::new);
            int N = NM[0];
            int M = NM[1];

            Arrays.sort(trees, (a, b) -> Integer.compare(a, b));

            bw.write(String.valueOf(find(N, M)));
            bw.flush();

        }

    }

    private static long find(int N, int M) {
        long minHeight = 0;
        long maxHeight = trees[N - 1] - 1;
        if (M == 1) {
            return maxHeight;
        }

        long best = 0;
        while (minHeight <= maxHeight) {
            long mid = (minHeight + maxHeight) / 2;

            if (getTotal(mid) >= M) {
                best = mid;
                minHeight = mid + 1;
            } else {
                maxHeight = mid - 1;
            }
        }

        return best;
    }

    private static long getTotal(long height) {
        long sum = 0;
        for (int i = trees.length - 1; i >= 0; i--) {
            if (trees[i] <= height)
                break;
            sum += (trees[i] - height);
        }
        return sum;
    }

}
