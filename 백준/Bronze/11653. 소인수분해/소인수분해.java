import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(br.readLine());
            int i = 2;
            List<Integer> list = new ArrayList<>();

            while (n > 1) {
                while (n % i != 0) {
                    i++;
                }
                list.add(i);
                n = n / i;
            }
            list.forEach(System.out::println);
        }
    }
}
