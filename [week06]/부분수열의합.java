package KB_ITL_CT;
import java.io.*;
import java.util.*;
public class 부분수열의합 {
	static int N,S;
	static int[]arr;
	static int answer = 0;
	public static void main(String[]args)throws IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(bf.readLine());
		arr = new int[N];

		dfs(0,0);
		System.out.println(answer);
	}
	public static void dfs(int index,int sum) {
		if(index==N) {
			if(sum==S)answer+=1;
			return;
		}

		//현재 원소 포함하기
		dfs(index+1, sum+arr[index]);
		//현재 원소 포함시키지 않기
		dfs(index+1, sum);
	}
}
