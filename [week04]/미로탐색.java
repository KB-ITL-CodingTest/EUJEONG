package KB_ITL_CT;
import java.io.*;
import java.util.*;
public class 미로탐색 {
	static int N,M;
	static int arr[][];
	static boolean visited[][];
	static int dx[]= {-1,0,0,1}, dy[]= {0,-1,1,0};
	static Queue<int[]> q = new LinkedList<>();
	public static void main(String[]args) throws IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		visited = new boolean[N][M]; //메모리 초과 방지
		for(int i=0;i<N;i++) {
			String line = bf.readLine();
			for(int j=0;j<M;j++) {
				if(line.charAt(j)=='1')arr[i][j]=1;
				else arr[i][j]=0;
			}
		}
		int answer =0;
		visited[0][0]=true;
		q.add(new int[] {0,0,1});
		while(!q.isEmpty()) {
			int[] now = q.poll();
		
			int cx = now[0];
			int cy = now[1];
			int cc = now[2]; 
			if(cx==N-1&&cy==M-1) {
				answer=cc;
				break;
			}
			for(int i=0;i<4;i++) {
				int nx = cx + dx[i];
				int ny = cy + dy[i];
				if((nx>=0&&nx<N)&&(ny>=0&&ny<M)) {
					if(arr[nx][ny]==1&&!visited[nx][ny]) {
						visited[nx][ny]=true;
						
						q.add(new int[] {nx,ny,cc+1});
					}
				}
			}
		}
		System.out.println(answer);
	}
}
