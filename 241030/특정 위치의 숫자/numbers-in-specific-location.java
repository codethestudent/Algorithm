import java.util.*;

public class Main {
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        int answer = 0;
        Scanner sc = new Scanner(System.in);
        for(int i = 0; i<10; i++){
            answer += sc.nextInt();
        }
        System.out.println(answer);
    }
}