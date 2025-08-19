import java.io.*;
import java.util.*;

public class Main {
    static class Recipe {
        int out;        // 결과 아이템
        int need;       // 남은 재료 개수 (초기 2)
        long sum;       // 확정된 재료비 합
        Recipe(int out) { this.out = out; this.need = 2; this.sum = 0; }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        long[] d = new long[n+1];
        st = new StringTokenizer(br.readLine());
        for (int i=1; i<=n; i++) d[i] = Long.parseLong(st.nextToken());

        // 각 아이템을 재료로 쓰는 제작식 목록
        List<Integer>[] uses = new ArrayList[n+1];
        for (int i=1; i<=n; i++) uses[i] = new ArrayList<>();

        Recipe[] recipes = new Recipe[m];
        for (int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            recipes[i] = new Recipe(a);
            uses[x].add(i);
            uses[y].add(i);
        }

        boolean[] done = new boolean[n+1];
        PriorityQueue<long[]> pq = new PriorityQueue<>(Comparator.comparingLong(o -> o[0]));
        for (int i=1; i<=n; i++) pq.offer(new long[]{d[i], i});

        while (!pq.isEmpty()) {
            long[] cur = pq.poll();
            long cost = cur[0];
            int u = (int) cur[1];
            if (done[u]) continue;
            done[u] = true;           // u의 최소비용 확정

            // u를 재료로 쓰는 모든 제작식 갱신
            for (int rid : uses[u]) {
                Recipe r = recipes[rid];
                if (r.need > 0) {
                    r.need--;
                    r.sum += cost;
                    if (r.need == 0) {
                        int a = r.out;
                        if (r.sum < d[a]) {
                            d[a] = r.sum;
                            pq.offer(new long[]{d[a], a});
                        }
                    }
                }
            }
        }

        System.out.println(d[1]);
    }
}
