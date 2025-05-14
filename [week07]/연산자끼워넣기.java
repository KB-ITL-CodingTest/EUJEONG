package KB_ITL_CT;
import java.io.*;
import java.util.*;
public class w7_연산자끼워넣기 {
	static int N,plus,minus,multiple,divide;
	static int min = Integer.MAX_VALUE;
	static int max = Integer.MIN_VALUE;
	static int[]arr;
	static int[]op;
	public static void main(String[]args)throws IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(bf.readLine());
		arr = new int[N];
		StringTokenizer st = new StringTokenizer(bf.readLine());
		for(int i=0;i<N;i++) {
			arr[i]= Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(bf.readLine());
		op = new int[4];
		for(int i=0;i<4;i++) {
			op[i]=Integer.parseInt(st.nextToken());
		}
		dfs(0,arr[0]);
		System.out.println(max);
		System.out.println(min);
	}
	public static void dfs(int depth, int sum) {
		if(depth==N-1) {
			min = Math.min(min, sum);
			max = Math.max(max, sum);
			return;
		}
		if(op[0]!=0) {
			op[0]-=1;
			dfs(depth+1,sum+arr[depth+1]);
			op[0]+=1;
		}
		if(op[1]!=0) {
			op[1]-=1;
			dfs(depth+1,sum-arr[depth+1]);
			op[1]+=1;
		}
		if(op[2]!=0) {
			op[2]-=1;
			dfs(depth+1,sum*arr[depth+1]);
			op[2]+=1;
		}
		if(op[3]!=0) {
			op[3]-=1;
			if(sum<0&&arr[depth+1]>0) {
				sum=(sum*(-1))/arr[depth+1];
				sum*=(-1);
			}else {
				sum = sum/arr[depth+1];
			}
			dfs(depth+1,sum);
			op[3]+=1;
		}
	}
}
