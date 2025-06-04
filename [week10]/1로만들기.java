import java.io.*;
import java.util.*;
public class Main {
	public static void main(String[]args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[]dp = new int[N+1];
		for(int i=1;i<N;i++)dp[i]=Integer.MAX_VALUE;
		dp[N]=0;
		
		for(int j=N;j>1;j--) {
			if(dp[j]==Integer.MAX_VALUE)continue;
			if(j/3>=1&&j%3==0) {
				dp[j/3]=Math.min(dp[j/3], dp[j]+1);

			}
			if(j/2>=1&&j%2==0) {
				dp[j/2]=Math.min(dp[j/2], dp[j]+1);
			}
			if(j-1>=1) {
				dp[j-1]=Math.min(dp[j-1], dp[j]+1);
			}
		}
		
		System.out.println(dp[1]);
		sc.close();
	}
}
