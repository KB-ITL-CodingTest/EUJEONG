package KB_ITL_CT;
import java.util.*;
import java.io.*;
public class 연결요소의개수 {
	static int N,M,answer=0;
	static ArrayList<Integer>arr[];
	static boolean[] visited;
	public static void main(String[]args) throws IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new ArrayList[N+1];
		visited = new boolean[N+1];
		for(int i=1;i<=N;i++)arr[i]=new ArrayList<>();
		
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(bf.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			arr[from].add(to);
			arr[to].add(from);
		}
		
		for(int i=1;i<=N;i++) {
			
			if(!visited[i]) {
				answer+=1;
				dfs(i);
			}
		}
		System.out.println(answer);
	}
	public static void dfs(int now) {
		visited[now]=true;
		for(Integer e:arr[now]) {
			if(!visited[e]) {
				dfs(e);
			}
		}
	}
}
