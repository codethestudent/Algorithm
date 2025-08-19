import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
    private static List<Integer>[] connectedNodes;
    private static int[] answerList;
    private static boolean[] visited;

    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            int N = Integer.parseInt(br.readLine());
            visited = new boolean[N + 1];
            answerList = new int[N + 1];
            connectedNodes = new ArrayList[N + 1];

            for (int i = 1; i <= N; i++) {
                connectedNodes[i] = new ArrayList<>();
            }

            for (int i = 1; i < N; i++) {
                int[] connection = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
                connectedNodes[connection[0]].add(connection[1]);
                connectedNodes[connection[1]].add(connection[0]);
            }

            dfs(1, 0);
            for (int i = 2; i <= N; i++) {
                System.out.println(answerList[i]);
            }
        }
    }

    private static void dfs(int start, int prev) {
        if (!visited[start]) {
            visited[start] = true;
            answerList[start] = prev;

            for (int i : connectedNodes[start]) {
                dfs(i, start);
            }
        }
    }

}
