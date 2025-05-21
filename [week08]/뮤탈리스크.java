package KB_ITL_CT;
import java.util.*;
import java.io.*;
public class w8_뮤탈리스크 {
	public static int[][][]dp;
	public static void main(String[]args) throws IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(bf.readLine());
		
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		int[]arr = new int[3];//체력 저장
		for(int i=0;i<N;i++)arr[i]=Integer.parseInt(st.nextToken());
		dp = new int[arr[0]+1][arr[1]+1][arr[2]+1];//입력받은 체력만큼 배열 초기화
		
		for(int i=0;i<dp.length;i++) {
			for(int j=0;j<dp[i].length;j++) {
				Arrays.fill(dp[i][j], -1);
			}
		}
		System.out.println(dfs(arr[0],arr[1],arr[2]));
	}
	public static int dfs(int a1,int a2,int a3) {
		a1 = Math.max(a1, 0);
		a2 = Math.max(a2, 0);
		a3 = Math.max(a3, 0);
		
		if(a1==0&&a2==0&&a3==0) {
			return 0;//체력이 모두 0인 경우
		}
		if(dp[a1][a2][a3]!=-1) {
			return dp[a1][a2][a3];
		}
		int result = Integer.MAX_VALUE;
		//모든 경우에 대한 최적 찾기
		result = Math.min(result, dfs(a1 - 9, a2 - 3, a3 - 1) + 1);
        result = Math.min(result, dfs(a1 - 9, a2 - 1, a3 - 3) + 1);
        result = Math.min(result, dfs(a1 - 3, a2 - 9, a3 - 1) + 1);
        result = Math.min(result, dfs(a1 - 3, a2 - 1, a3 - 9) + 1);
        result = Math.min(result, dfs(a1 - 1, a2 - 3, a3 - 9) + 1);
        result = Math.min(result, dfs(a1 - 1, a2 - 9, a3 - 3) + 1);
        return dp[a1][a2][a3]=result;
	}
}
