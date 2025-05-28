package KB_ITL_CT;
import java.io.*;
import java.util.*;
public class w9_앱 {
	public static void main(String[]args)throws IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(bf.readLine());
		int[]usememory = new int[N];
		int[]cost = new int[N];
		for(int i=0;i<N;i++) {
			usememory[i]=Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(bf.readLine());
		for(int i=0;i<N;i++) {
			cost[i]=Integer.parseInt(st.nextToken());
		}
		int[][]dp = new int[N][10001];

        int answer = Integer.MAX_VALUE;
        for (int i = 0; i < N; i++) {
            int c = cost[i];
            int memory = usememory[i];

            for (int j = 0; j <= 10000; j++) {
                if (i == 0) {
                    if (j >= c) dp[i][j] = memory;
                } else {
                    if (j >= c) {
                        dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - c] + memory);
                    } else {
                        dp[i][j] = dp[i - 1][j];
                    }
                }
                if (dp[i][j] >= M) {
                    answer = Math.min(answer, j);
                }
            }
        }
        System.out.println(answer);
	}
}
