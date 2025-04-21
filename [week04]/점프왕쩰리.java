package KB_ITL_CT;
import java.io.*;
import java.util.*;
public class 점프왕쩰리 {
	static int N;
	static int arr[][];
	static boolean visited[][];
	static int dx[]= {0,1}, dy[]= {1,0};
	static boolean arrived = false;
	public static void main(String[]args) throws IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		N = Integer.parseInt(st.nextToken());
		
		arr = new int[N][N];
		visited = new boolean[N][N];
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(bf.readLine());
			for(int j=0;j<N;j++) {
				arr[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		
		dfs(0,0,arr[0][0]);
		visited[0][0]=true;
		if(arrived)System.out.println("HaruHaru");
		else System.out.println("Hing");
	}
	public static void dfs(int x, int y, int count) {
		if(arr[x][y]==-1) {
			arrived = true;
			return;
		}
		for(int i=0;i<2;i++) {
			int nx = x + (count*dx[i]);
			int ny = y + (count*dy[i]);
			if((nx>=0&&nx<N)&&(ny>=0&&ny<N)) {
				if(!visited[nx][ny]) {
					visited[nx][ny]=true;
					dfs(nx,ny,arr[nx][ny]);
				}
			}
		}
	}
}
