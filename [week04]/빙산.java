package KB_ITL_CT;
import java.io.*;
import java.util.*;
public class 빙산 {
	static int N,M;
	static int arr[][];
	static boolean visited[][];
	static int dx[]= {-1,0,0,1}, dy[]= {0,-1,1,0};
	public static void main(String[]args) throws IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		visited = new boolean[N][M];
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(bf.readLine());
			for(int j=0;j<M;j++) {
				arr[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		int temp[][]=new int[N][M];
		int time = 0; //시간 경과
		while(!all_melted()) {//빙산이 다 녹지 않은 경우 반복 
			if(splited()) {
				System.out.println(time);
				return;
			}
			visited = new boolean[N][M]; //방문 배열 초기화
			copy(temp,arr);
			for(int i=0;i<N;i++) {
				for(int j=0;j<M;j++) {
					if(!visited[i][j]&&temp[i][j]!=0) {
						//아직 방문하지 않고 바다가 아닌 빙산인 경우
						int zero=0;//주변에 0이 저장된 칸의 개수
						for(int k=0;k<4;k++) {
							if(temp[i+dx[k]][j+dy[k]]==0)zero+=1;//주변이 0인 경우 개수 세기
						}
						arr[i][j]-=zero;
						if(arr[i][j]<0)arr[i][j]=0; //높이는 0보다 더 줄어들지는 않으므로 음수로 바뀌면 다시 0으로
					}
				}
			}
			
			
			time+=1; //1년 경과
		}
		//빙산이 다 녹을 때까지 두 덩어리 이상으로 분리되지 않은 경우
		if(!splited())System.out.println(0);
	}
	
	public static boolean all_melted() {//현재 빙산이 다 녹아있는지의 여부를 알려주는 함수
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(arr[i][j]!=0)return false; //다 녹지 않은 경우 false 반환
			}
		}
		return true; //다 녹은 경우 true 반환
	}
	
	public static boolean splited() {//현재 빙산이 두 덩어리 이상으로 분리되었는지 여부를 알려주는 함수
		int group = 0; //덩어리의 개수
		visited = new boolean[N][M];//방문 배열 초기화
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(arr[i][j]!=0&&!visited[i][j]) {
					dfs(i,j);
					group+=1;
				}
			}
		}
		if(group>=2)return true;
		else return false;
	}
	
	public static void dfs(int x, int y) {
		visited[x][y]=true;
		for(int i=0;i<4;i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if(arr[nx][ny]!=0&&!visited[nx][ny]) {
				dfs(nx,ny);
			}
		}
	}
	
	public static void copy(int[][]A,int[][]B) {
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				A[i][j]=B[i][j];
			}
		}
	}
}
