import java.io.*;
import java.util.*;
import java.util.*;
public class Main {
	public static int node, line, meter, start;
	public static int[]visited;
	public static ArrayList<Integer>[] lst;
	public static void main(String[]args)throws IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		node = Integer.parseInt(st.nextToken());
		line = Integer.parseInt(st.nextToken());
		meter = Integer.parseInt(st.nextToken());
		start = Integer.parseInt(st.nextToken());
		
		lst = new ArrayList[node+1];
		visited= new int[node+1];
		for(int i=0;i<=node;i++)visited[i]=-1;
		for(int i=0;i<=node;i++) {
			lst[i]=new ArrayList<>();
		}
		//간선 정보 입력
		for(int i=0;i<line;i++) {
			st = new StringTokenizer(bf.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			lst[x].add(y);
		}
		bfs(meter,start);
		List<Integer>answer=new ArrayList<>();
		for(int i=0;i<=node;i++) {
			if(visited[i]==meter)answer.add(i);
		}

		if(answer.isEmpty())System.out.println(-1);
		else {
			Collections.sort(answer);
			for(int item:answer)System.out.println(item);
		}
	}
	public static void bfs(int k, int start) {
		Queue<Integer> q = new LinkedList<>();
		q.add(start);
		visited[start]++;
		while(!q.isEmpty()) {
			int temp = q.poll();
			for(int i:lst[temp]) {
				if(visited[i]==-1) {
					visited[i]=visited[temp]+1;
					q.add(i);
				}
			}
		}
	}
}
