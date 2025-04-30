package KB_ITL_CT;
import java.io.*;
import java.util.*;
public class 내리막길 {
	static int M,N; //M은 세로
	static int[][]arr;
	static int[][]count;
	static boolean [][]visited;
	static int []dx = {-1,0,0,1};
	static int []dy = {0,-1,1,0};
	public static void main(String[]args)throws IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		arr = new int[M][N];
		visited = new boolean[M][N];
		count = new int[M][N]; //각 인덱스 (x,y)에서 도착점으로 가는 경로의 개수
		for(int i=0;i<M;i++) {
			for(int j=0;j<N;j++) {
				count[i][j]=-1;
			}
		}
		
		for(int i=0;i<M;i++) {//배열의 정보 저장
			st = new StringTokenizer(bf.readLine());
			for(int j=0;j<N;j++) {
				arr[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		
		System.out.println(dfs(0,0));
	}
	public static int dfs(int x, int y) {
		
		if(x==M-1&&y==N-1) {
			return 1;
		}
		if(count[x][y]!=-1) {
			return count[x][y];
		}
		count[x][y]=0;
		for(int i=0;i<4;i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if((nx>=0&&nx<M)&&(ny>=0&&ny<N)) {
				if(arr[nx][ny]<arr[x][y]) {
					count[nx][ny]+=dfs(nx,ny);
				}
			}
		}
		return count[x][y];
		
	}
}
