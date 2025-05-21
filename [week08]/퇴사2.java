import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[]args) throws IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(bf.readLine());
		StringTokenizer st;
		int []t = new int[N+1];
		int []p = new int[N+1];
		int []dp = new int[N+2];
		for(int i=0;i<=N;i++)dp[i]=Integer.MIN_VALUE;
		
		for(int i=1;i<=N;i++) {
			st = new StringTokenizer(bf.readLine());
			t[i]=Integer.parseInt(st.nextToken());
			p[i]=Integer.parseInt(st.nextToken());
		}
		for(int i=N;i>0;i--) {
			if(i+t[i]-1>N)dp[i]=dp[i+1];
			else {
				dp[i]=Math.max(dp[i+1], dp[i+t[i]]+p[i]);
			}
		}
		
		
		System.out.print(dp[1]);
	}
}
