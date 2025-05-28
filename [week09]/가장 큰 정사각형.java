package KB_ITL_CT;
import java.util.*;
import java.io.*;
public class w9_가장큰정사각형 {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		int[][] arr = new int[n][m];
		for(int i = 0; i < n; i++) {
			String line = bf.readLine();
			for(int j = 0; j < m; j++) {
				arr[i][j] = line.charAt(j) - '0';
			}
		}
		
		int[][] dp = new int[n][m];
		int answer = 0;
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				if(arr[i][j] == 1) {
					if(i == 0 || j == 0) {
						dp[i][j] = 1;
					} else {
						dp[i][j] = Math.min(dp[i-1][j], Math.min(dp[i-1][j-1], dp[i][j-1])) + 1;
					}
					answer = Math.max(answer, dp[i][j]);
				}
			}
		}
		
		System.out.println(answer * answer);
	}
}
