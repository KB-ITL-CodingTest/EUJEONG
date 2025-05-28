package KB_ITL_CT;
import java.io.*;
import java.util.*;
public class w9_진우의달여행 {
	public static void main(String[]args)throws IOException{
		BufferedReader bf=  new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][]arr = new int[N][M];
		int[][][]dp = new int[N][M][3];//(1,2,3번) 방향으로부터 온 점 (n,m)
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(bf.readLine());
			for(int j=0;j<M;j++) {
				arr[i][j]=Integer.parseInt(st.nextToken());
				Arrays.fill(dp[i][j], (int)1e9);
			}
		}
		
		for(int j=0;j<M;j++) {
			dp[0][j][0]=arr[0][j];
			dp[0][j][1]=arr[0][j];
			dp[0][j][2]=arr[0][j];
		}
		for(int i=1;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(j==0) {
					dp[i][j][0]=Math.min(dp[i-1][j+1][1],dp[i-1][j+1][2])+arr[i][j];
					dp[i][j][1]=dp[i-1][j][0]+arr[i][j];
				}else if(j==M-1) {
					dp[i][j][2]=Math.min(dp[i-1][j-1][1],dp[i-1][j-1][0])+arr[i][j];
					dp[i][j][1]=dp[i-1][j][2]+arr[i][j];
				}else {
					dp[i][j][0]=Math.min(dp[i-1][j+1][1],dp[i-1][j+1][2])+arr[i][j];
					dp[i][j][1]=Math.min(dp[i-1][j][0], dp[i-1][j][2])+arr[i][j];
					dp[i][j][2]=Math.min(dp[i-1][j-1][1], dp[i-1][j-1][0])+arr[i][j];
				}
			}
		}
		int answer = (int)1e9;
		for(int i=0;i<M;i++) {
			for(int j=0;j<3;j++) {
				answer = Math.min(answer, dp[N-1][i][j]);
			}
		}
		System.out.println(answer);
	}
}
