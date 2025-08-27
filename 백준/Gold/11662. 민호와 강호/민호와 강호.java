import java.io.*;
import java.util.Locale;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        double Ax = Double.parseDouble(st.nextToken());
        double Ay = Double.parseDouble(st.nextToken());
        double Bx = Double.parseDouble(st.nextToken());
        double By = Double.parseDouble(st.nextToken());
        double Cx = Double.parseDouble(st.nextToken());
        double Cy = Double.parseDouble(st.nextToken());
        double Dx = Double.parseDouble(st.nextToken());
        double Dy = Double.parseDouble(st.nextToken());

        // R = A - C
        double Rx = Ax - Cx, Ry = Ay - Cy;
        // U = B - A, V = D - C, W = U - V
        double Ux = Bx - Ax, Uy = By - Ay;
        double Vx = Dx - Cx, Vy = Dy - Cy;
        double Wx = Ux - Vx, Wy = Uy - Vy;

        double RR = Rx*Rx + Ry*Ry;          // R·R
        double RW = Rx*Wx + Ry*Wy;          // R·W
        double WW = Wx*Wx + Wy*Wy;          // W·W

        double t;
        if (WW == 0.0) {                    // 상대 속도 0 → 거리 일정
            t = 0.0;
        } else {
            t = - RW / WW;                  // 이차함수 최소점
            if (t < 0.0) t = 0.0;           // clamp to [0,1]
            else if (t > 1.0) t = 1.0;
        }

        double dx = Rx + t * Wx;
        double dy = Ry + t * Wy;
        double dist = Math.hypot(dx, dy);   // sqrt(dx*dx + dy*dy)

        System.out.printf(Locale.ROOT, "%.10f%n", dist);
    }
}
