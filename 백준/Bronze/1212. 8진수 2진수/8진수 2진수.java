import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String octalString = br.readLine();
        StringBuilder binaryStringBuilder = new StringBuilder();

        // 8진수 "0"이 입력된 경우, "0"을 출력하고 종료
        if (octalString.equals("0")) {
            System.out.println("0");
            return;
        }

        // 8진수 각 자리에 해당하는 2진수(3자리)
        String[] binaryMap = {"000", "001", "010", "011", "100", "101", "110", "111"};

        // 8진수 문자열의 각 문자를 순회하며 2진수로 변환
        for (int i = 0; i < octalString.length(); i++) {
            int digit = octalString.charAt(i) - '0';
            binaryStringBuilder.append(binaryMap[digit]);
        }

        // 변환된 2진수 문자열의 맨 앞 "0"들을 제거
        // (예: "001010" -> "1010")
        while (binaryStringBuilder.length() > 1 && binaryStringBuilder.charAt(0) == '0') {
            binaryStringBuilder.deleteCharAt(0);
        }

        System.out.println(binaryStringBuilder.toString());
    }
}