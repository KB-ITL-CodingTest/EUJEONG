import java.io.*;
public class Main {
	public static void main(String[]args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		if(N==0) {
			System.out.println(0);
			System.out.println(0);
			return;
		}
		
		int[] dp = new int[1+Math.abs(N)];
		dp[1]=1;
		
		if(N>=0) {
			for(int i=2;i<=N;i++) {
				dp[i]=(dp[i-1]+dp[i-2])%1000000;
			}
		}else {
			for(int i=2;i<=-N;i++) {
				dp[i]=(dp[i-2]-dp[i-2])%1000000;
			}
		}
		
		System.out.println(dp[Math.abs(N)]/Math.abs(dp[Math.abs(N)]));
		System.out.println(Math.abs(dp[Math.abs(N)]));
	}
}
