import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {

            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            int[] arr1 = new int[N];
            int[] arr2 = new int[M];

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                arr1[i] = Integer.parseInt(st.nextToken());
            }

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < M; i++) {
                arr2[i] = Integer.parseInt(st.nextToken());
            }

            StringBuilder sb = new StringBuilder();
            int k = 0;
            int i = 0;
            int j = 0;
            while (i < N && j < M) {
                if (arr1[i] >= arr2[j]) {
                    sb.append(arr2[j++]).append(" ");
                } else {
                    sb.append(arr1[i++]).append(" ");
                }
            }

            while (i < N) {
                sb.append(arr1[i++]).append(" ");
            }
            while (j < M) {
                sb.append(arr2[j++]).append(" ");
            }

            bw.write(sb.toString());
            bw.flush();
        }
    }
}
