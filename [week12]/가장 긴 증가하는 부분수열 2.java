package KB_ITL;
import java.io.*;
import java.util.*;
public class w12_가장긴증가하는부분수열2 {
    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(bf.readLine());
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] answer = new int[n];
        answer[0] = arr[0];
        int len = 1;

        for(int i = 1; i < n; i++) {
            int now = arr[i];

            if (now > answer[len - 1]) {
                answer[len++] = now;
            } else {
                int index = lowerBound(answer, 0, len - 1, now);
                answer[index] = now;
            }
        }

        System.out.println(len);
    }

    // lowerBound: 처음으로 answer[i] >= key가 되는 인덱스를 반환
    public static int lowerBound(int[] arr, int start, int end, int key) {
        while (start < end) {
            int mid = (start + end) / 2;
            if (arr[mid] < key) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        return start;
    }
}
