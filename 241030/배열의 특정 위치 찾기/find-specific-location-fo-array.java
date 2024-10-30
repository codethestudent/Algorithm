import java.util.*;

public class Main {
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[10];
        for(int i = 0; i<10; i++){
            arr[i] = sc.nextInt();
        }
        int answer = 0;
        for(int i = 1; i<10; i += 2){
            answer += arr[i];
        }
        System.out.print(answer + " ");

        answer = 0;
        int n = 0;
        for(int i = 1; i*3<10; i++){
            answer += arr[i*3 -1];
            n++;
        }

        System.out.printf("%.1f",(double) answer / n);
    }
}