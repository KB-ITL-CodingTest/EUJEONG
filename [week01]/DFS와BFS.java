package KB_ITL_CT;
import java.util.*;
import java.io.*;
public class DFS와BFS {
	static int N, M, V;
	static boolean[]visited;
	static List<Integer>[] arr;
	static Queue<Integer>q = new LinkedList<>();
	public static void main(String[]args)throws IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken());
		
		visited = new boolean[N+1];
		arr = new List[N+1];
		for(int i=0;i<=N;i++)arr[i]=new LinkedList<Integer>();
		
		//정점 정보 입력
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(bf.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			arr[from].add(to);
			arr[to].add(from);
		}
		//정점이 작은 순서부터 방문하기 위해 정렬 
		
		for(int i=0;i<=N;i++) {
			Collections.sort(arr[i]);
		}
		DFS(V);
		System.out.println();
		visited = new boolean[N+1];
		BFS(V);
	}
	
	public static void DFS(int start) {
		System.out.print(start+" ");
		visited[start]=true;
		for(Integer e:arr[start]) {
			if(!visited[e]) {
				DFS(e);
			}
		}
	}
	public static void BFS(int start) {
		visited[start]=true;
		System.out.print(start+" ");
		q.add(start);
		while(!q.isEmpty()) {
			int now = q.poll();
			for(Integer e:arr[now]) {
				if(!visited[e]) {
					visited[e]=true;
					System.out.print(e+" ");
					q.add(e);
				}
			}
		}
	}
}
