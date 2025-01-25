import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    static int[] alphabet = new int[26];
    static Map<Character, Integer> map = new HashMap<>();

    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int index = 0;
            for (char i = 'a'; i <= 'z'; i++) {
                alphabet[index] = -1;
                map.put(i, index++);
            }

            char[] word = br.readLine().toCharArray();

            for (int i = 0; i < word.length; i++) {
                if (alphabet[map.get(word[i])] != -1) {
                    continue;
                } else {
                    alphabet[map.get(word[i])] = i;
                }
            }

            for (int i : alphabet) {
                System.out.print(i + " ");
            }
        }
    }

}
