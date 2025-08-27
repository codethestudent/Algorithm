import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {

            int N = Integer.parseInt(br.readLine());
            Map<Integer, Integer> bag = new HashMap<>((int) (N / 0.75f) + 1);

            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int i = 0; i < N; i++) {
                int x = Integer.parseInt(st.nextToken());
                bag.put(x, bag.getOrDefault(x, 0) + 1);
            }

            int M = Integer.parseInt(br.readLine());

            StringBuilder sb = new StringBuilder();
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < M; i++) {
                int q = Integer.parseInt(st.nextToken());
                sb.append(bag.getOrDefault(q, 0)).append(' ');
            }

            bw.write(sb.toString());

            bw.flush();

        }

    }
}
