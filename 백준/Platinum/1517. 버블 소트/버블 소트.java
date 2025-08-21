import java.io.*;
import java.util.Arrays;

public class Main {
    private static long answer = 0;

    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            int N = Integer.parseInt(br.readLine());
            int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            mergeSort(arr, 0, arr.length - 1);

            bw.write(String.valueOf(answer));
            bw.flush();
        }

    }

    private static void mergeSort(int[] arr, int left, int right) {
        if (left >= right)
            return;
        int mid = (left + right) / 2;

        mergeSort(arr, left, mid); // 0 1 (7, 8)
        mergeSort(arr, mid + 1, right); // 2 3 (5, 6)
        merge(arr, left, mid, right); // arr = (5, 6, 7, 8)
    }

    private static void merge(int[] arr, int left, int mid, int right) {
        // { 0(8) - 1(7) } & { 0(7), 1(8) } - { 2(5) , 3(6) }
        int[] temp = new int[right - left + 1];

        int i = left;
        int j = mid + 1;
        int k = 0;

        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
                answer += (mid - i + 1);
            }
        }

        while (i <= mid) {
            temp[k++] = arr[i++];
        }
        while (j <= right) {
            temp[k++] = arr[j++];
        }

        for (int t = 0; t <= right - left; t++) {
            arr[left + t] = temp[t];
        }
    }
}
