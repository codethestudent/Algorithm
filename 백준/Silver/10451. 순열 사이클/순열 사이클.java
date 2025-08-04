import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    static List<Integer>[] nodes;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int T = Integer.parseInt(br.readLine());
            List<Integer> answers = new ArrayList<>();

            for (int i = 0; i < T; i++) {
                int nodeCount = Integer.parseInt(br.readLine());
                nodes = new ArrayList[nodeCount + 1];
                visited = new boolean[nodeCount + 1];

                for (int j = 1; j <= nodeCount; j++) {
                    nodes[j] = new ArrayList<>();
                }
                int[] inputs = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
                for (int k = 1; k <= nodeCount; k++) {
                    nodes[k].add(inputs[k - 1]);
                    nodes[inputs[k - 1]].add(k);
                }

                int pGraphCount = 0;
                for (int j = 1; j < visited.length; j++) {
                    if (!visited[j]) {
                        pGraphCount++;
                        dfs(j);
                    }
                }
                answers.add(pGraphCount);
            }

            answers.forEach(System.out::println);
        }
    }

    private static void dfs(int start) {
        if (!visited[start]) {
            visited[start] = true;
            for (int node : nodes[start]) {
                dfs(node);
            }
        } else {
            return;
        }
    }


}
