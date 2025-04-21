import java.io.*;
import java.util.*;
public class Main {
	public static int N,M;//M은 배추밭의 가로(=열)
	public static int [][]arr;
	public static boolean [][]visited;
	public static int [] dx= {-1,0,0,1};
	public static int [] dy = {0,-1,1,0};
	public static void main(String[]args) throws IOException{
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(bf.readLine());
		
		int num=Integer.parseInt(st.nextToken());
		int []answer=new int[num];
		for(int i=0;i<num;i++) {
			st=new StringTokenizer(bf.readLine());
			M=Integer.parseInt(st.nextToken());
			N=Integer.parseInt(st.nextToken());
			arr=new int[N][M];
			visited = new boolean [N][M];
			int cab=Integer.parseInt(st.nextToken());
			for(int j=0;j<cab;j++) {
				st=new StringTokenizer(bf.readLine());
				int k=Integer.parseInt(st.nextToken());
				int s=Integer.parseInt(st.nextToken());
				arr[s][k]=1;
			}
			int snake=0;
			//배추흰지렁이 마리 수 구하기
			for(int j=0;j<N;j++) {
				for(int k=0;k<M;k++) {
					if(arr[j][k]==1&& !visited[j][k]) {
						snake+=1;
						dfs(j,k);
					}
				}
			}
			answer[i]=snake;
		}
		for(int k=0;k<num;k++)System.out.println(answer[k]);
	}
	
	public static void dfs(int j,int k) {
		visited[j][k]=true;
		for(int i=0;i<4;i++) {
			int nx=j+dx[i];
			int ny=k+dy[i];
			if((nx>=0&&nx<N)&&(ny>=0&&ny<M)) {
				if(arr[nx][ny]==1&&!visited[nx][ny]) {
					dfs(nx,ny);
				}
			}
		}
	}
}
