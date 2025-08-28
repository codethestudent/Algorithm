import java.io.*;
import java.util.*;

public class Main {
    private static double Rx;
    private static double Wx;
    private static double Ry;
    private static double Wy;

    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {

            StringTokenizer st = new StringTokenizer(br.readLine());

            double Ax = Double.parseDouble(st.nextToken());
            double Ay = Double.parseDouble(st.nextToken());
            double Bx = Double.parseDouble(st.nextToken());
            double By = Double.parseDouble(st.nextToken());
            double Cx = Double.parseDouble(st.nextToken());
            double Cy = Double.parseDouble(st.nextToken());
            double Dx = Double.parseDouble(st.nextToken());
            double Dy = Double.parseDouble(st.nextToken());

            // R = 민호 기준으로 강호의 초기 위치
            Rx = Ax - Cx;
            Ry = Ay - Cy;

            double Ux = Bx - Ax;
            double Uy = By - Ay;
            double Vx = Dx - Cx;
            double Vy = Dy - Cy;

            // W = 민호와 강호의 거리 차이
            Wx = Ux - Vx;
            Wy = Uy - Vy;

            double lo = 0.0;
            double hi = 1.0;

            for (int i = 0; i < 100; i++) {
                double m1 = (2 * lo + hi) / 3.0;
                double m2 = (lo + 2 * hi) / 3.0;

                if (getDistance(m1) < getDistance(m2)) {
                    hi = m2;
                } else {
                    lo = m1;
                }
            }

            bw.write(String.format("%.10f%n", Math.sqrt(getDistance((hi + lo) / 2.0))));
            bw.flush();
        }
    }

    // getDistance = (초기 민호 강호의 거리 차이) + time(각 도착 지점과 시작 지점의 거리 차이)
    private static double getDistance(double time) {
        double lx = Rx + time * (Wx);
        double ly = Ry + time * (Wy);

        return Math.pow(lx, 2) + Math.pow(ly, 2);
    }
}
