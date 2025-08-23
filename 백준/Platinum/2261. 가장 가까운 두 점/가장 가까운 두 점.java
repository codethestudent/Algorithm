import java.io.*;
import java.util.*;

public class Main {
    static class P {
        int x, y;
        P(int x, int y) { this.x = x; this.y = y; }
    }

    static int dist2(P a, P b) {
        long dx = (long)a.x - b.x;
        long dy = (long)a.y - b.y;
        long v = dx*dx + dy*dy;
        return (int)v;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine().trim());
        P[] pts = new P[n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            pts[i] = new P(x, y);
        }

        // x, y 둘 다 정렬본 준비
        P[] px = pts.clone();
        Arrays.sort(px, (a,b) -> (a.x == b.x ? Integer.compare(a.y, b.y) : Integer.compare(a.x, b.x)));

        // 중복 좌표 조기 종료
        for (int i = 1; i < n; i++) {
            if (px[i-1].x == px[i].x && px[i-1].y == px[i].y) {
                System.out.println(0);
                return;
            }
        }

        P[] py = pts.clone();
        Arrays.sort(py, (a,b) -> (a.y == b.y ? Integer.compare(a.x, b.x) : Integer.compare(a.y, b.y)));

        int ans = closest(px, py);
        System.out.println(ans);
    }

    // 분할 정복 진입: px는 x정렬, py는 y정렬 (둘 다 같은 객체 참조 사용)
    static int closest(P[] px, P[] py) {
        int n = px.length;
        if (n <= 3) {
            int best = Integer.MAX_VALUE;
            for (int i = 0; i < n; i++) {
                for (int j = i+1; j < n; j++) best = Math.min(best, dist2(px[i], px[j]));
            }
            // py는 이미 y정렬 상태 유지
            return best;
        }

        int mid = n / 2;
        int midX = px[mid].x;

        // 좌/우 px 분할
        P[] qx = Arrays.copyOfRange(px, 0, mid);
        P[] rx = Arrays.copyOfRange(px, mid, n);

        // py를 좌/우로 분배 (Qx 멤버십으로 결정)
        HashSet<P> leftSet = new HashSet<>(Arrays.asList(qx));
        P[] qy = new P[qx.length];
        P[] ry = new P[rx.length];
        int qi = 0, ri = 0;
        for (P p : py) {
            if (leftSet.contains(p)) qy[qi++] = p;
            else ry[ri++] = p;
        }

        int d = Math.min(closest(qx, qy), closest(rx, ry));

        // 스트립 구성: |x - midX| < sqrt(d) ⇔ (x - midX)^2 < d
        ArrayList<P> strip = new ArrayList<>();
        for (P p : py) {
            long dx = (long)p.x - midX;
            if (dx*dx < d) strip.add(p);
        }

        // y정렬된 strip에서 각 점은 다음 최대 7개만 비교
        int m = strip.size();
        for (int i = 0; i < m; i++) {
            for (int j = i + 1; j < m && j <= i + 7; j++) {
                long dy = (long)strip.get(j).y - strip.get(i).y;
                if (dy*dy >= d) break; // y차이만으로도 d 미만 불가
                d = Math.min(d, dist2(strip.get(i), strip.get(j)));
            }
        }
        return d;
    }
}
