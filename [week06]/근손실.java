package KB_ITL_CT;
import java.io.*;
import java.util.*;
public class 근손실 {
	static int N,K,answer=0,weight=500;
	static int[]arr;
	static boolean[]visited;
	public static void main(String[]args)throws IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		arr = new int[N];
		st = new StringTokenizer(bf.readLine());
		
		for(int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i=0;i<N;i++) {
			visited = new boolean[N];
			visited[i]=true;
			weight+=arr[i];
			weight-=K;
			dfs(i,1);
		}
		
		System.out.println(answer);
	}
	public static void dfs(int start,int depth) {
		if(depth==N&&weight>=500) {
			answer+=1;
			return;
		}
		if(weight<500) {
			return;
		}
		for(int i=0;i<N;i++) {
			if(!visited[i]) {
				weight+=arr[i];
				weight-=K;
				visited[i]=true;
				dfs(arr[i],depth+1);
				visited[i]=false;
			}
		}
		
	}
}
