import java.io.*;

public class Main {
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            int n = Integer.parseInt(br.readLine());

            sb.append((int) (Math.pow(2, n) - 1)).append("\n");
            hanoi(n, 1, 3, 2);

            bw.write(sb.toString());
            bw.flush();
        }
    }

    private static void hanoi(int N, int from, int to, int via) {
        if (N == 1) {
            sb.append(from).append(" ").append(to).append("\n");
            return;
        }
        hanoi(N - 1, from, via, to); // { 4 | 1,2,3 | .. }
        sb.append(from).append(" ").append(to).append("\n"); // { .. | 1,2,3 | 4 }
        hanoi(N - 1, via, to, from); // { .. | .. | 1,2,3,4 }
    }
}
