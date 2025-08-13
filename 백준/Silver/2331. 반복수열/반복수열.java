import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static Map<Integer, Integer> map;

    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));) {
            int[] inputs = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            map = new LinkedHashMap<>();
            int A = inputs[0];
            int P = inputs[1];

            map.put(A, 1);

            while (map.get(A) == null || map.get(A) != 2) {
                A = calculate(A, P);
                map.put(A, map.get(A) == null ? 1 : map.get(A) + 1);
            }
            int answer = 0;
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                if (entry.getValue() == 2) {
                    break;
                }
                answer++;
            }

            bw.write(String.valueOf(answer));
            bw.flush();

        }
    }

    private static int calculate(int a, int p) {
        List<Integer> list = new ArrayList<>();

        while (a > 0) {
            list.add(a % 10);
            a = a / 10;
        }

        return list.stream()
                .mapToInt(i -> (int) Math.pow(i, p))
                .sum();
    }

}
