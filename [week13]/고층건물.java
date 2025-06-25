package KB_ITL;
import java.io.*;
import java.util.*;

public class w13_고층건물 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int[] arr = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int answer = 0;
        for (int i = 1; i <= n; i++) {
            int count = 0;

            // 왼쪽 탐색: 기울기 계속 감소
            double maxd = Double.POSITIVE_INFINITY;  // 초기값: +∞
            for (int j = i - 1; j >= 1; j--) {
                double d = (arr[j] - arr[i]) / (double)(j - i);
                if (d < maxd) {
                    maxd = d;
                    count++;
                }
            }

            // 오른쪽 탐색: 기울기 계속 증가
            maxd = Double.NEGATIVE_INFINITY;  // 초기값: -∞
            for (int j = i + 1; j <= n; j++) {
                double d = (arr[j] - arr[i]) / (double)(j - i);
                if (d > maxd) {
                    maxd = d;
                    count++;
                }
            }

            answer = Math.max(answer, count);
        }

        System.out.println(answer);
    }
}
