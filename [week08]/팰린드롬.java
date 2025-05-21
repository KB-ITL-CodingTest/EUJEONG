package KB_ITL_CT;
import java.util.*;
import java.io.*;
public class w8_팰린드롬 {
	public static void main(String[]args)throws IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        int[] arr = new int[N + 1];
        StringTokenizer st = new StringTokenizer(bf.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int M = Integer.parseInt(bf.readLine());

        int[][] dp = new int[N + 1][N + 1];

        // 길이가 1인 경우: 모든 단일 숫자는 팰린드롬
        for (int i = 1; i <= N; i++) {
            dp[i][i] = 1;
        }

        // 길이가 2인 경우: 두 숫자가 같으면 팰린드롬
        for (int i = 1; i < N; i++) {
            if (arr[i] == arr[i + 1]) {
                dp[i][i + 1] = 1;
            }
        }

        // 길이가 3 이상인 경우: 점화식 활용
        for (int length = 3; length <= N; length++) {  // 길이
            for (int start = 1; start <= N - length + 1; start++) {  // 시작점
                int end = start + length - 1;  // 끝점
                // 첫 번째와 마지막 문자가 같고, 가운데 부분이 팰린드롬일 때
                if (arr[start] == arr[end] && dp[start + 1][end - 1] == 1) {
                    dp[start][end] = 1;
                }
            }
        }

        // 쿼리 처리
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(bf.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            sb.append(dp[start][end]).append("\n");
        }
        System.out.print(sb);
	}
}
