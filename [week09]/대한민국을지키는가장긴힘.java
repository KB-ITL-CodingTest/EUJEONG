package KB_ITL_CT;
import java.util.*;
public class w9_대한민국을지키는가장긴힘 {
	public static void main(String[]args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		String S = sc.next();
		//dp[i] =  문자열의 처음부터 i번째 문자까지의 최소 분할 문자 개수 
		int []dp = new int[N+1];
		dp[0]=0;
		for(int i=1;i<=N;i++) {
			dp[i]=Integer.MAX_VALUE;
		}
		//숫자가 1이상 641이하, 0으로 시작하지 않는 경우에만 dp[i] 갱신
		for(int i=1;i<=N;i++) {
			for(int j=1;j<=3;j++) {
				if(i-j>=0) {
					String sub = S.substring(i-j,i);
					if(valid(sub))dp[i]=Math.min(dp[i], dp[i-j]+1);
				}
			}
		}
	}
	public static boolean valid(String s) {
		//0으로 시작하면 안 됨
		if(s.charAt(0)=='0')return false;
		//3자리 숫자 이상이면 안 됨
		if(s.length()>3||s.length()==0)return false;
		if(Integer.parseInt(s)>=1&&Integer.parseInt(s)<=641)return true;
		else return false;
	}
}
