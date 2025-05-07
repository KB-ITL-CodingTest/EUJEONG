package KB_ITL_CT;
import java.io.*;
import java.util.*;
public class 로또 {
	static int K;
	static int[]arr;
	static boolean[]visited;
	static StringBuilder sb;
	static StringBuilder answer=new StringBuilder();;
	public static void main(String[]args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		while(true) {
			st = new StringTokenizer(br.readLine());
			K = Integer.parseInt(st.nextToken());
			if(K==0)break;
			arr = new int[K];
			
			for(int i=0;i<K;i++)arr[i]=Integer.parseInt(st.nextToken());
			
			for(int i=0;i<=K-6;i++) {
				sb = new StringBuilder();
				visited = new boolean[K];
				visited[i]=true;
				sb.append(arr[i]+" ");
				dfs(i,0,sb);
				
			}
			System.out.println(answer.toString());
		}
		
	}
	public static void dfs(int start,int depth,StringBuilder sb) {
		if(depth==5) {
			//독일 로또를 완성한 경우
			sb.append("\n");
			answer.append(sb.toString());
			return;
		}
		for(int i=start+1;i<K;i++) {
			if(!visited[i]) {
				sb.append(arr[i]+" ");
				visited[i]=true;
				dfs(i,depth+1,sb);
				visited[i]=false;
			}
		}
	}
}
